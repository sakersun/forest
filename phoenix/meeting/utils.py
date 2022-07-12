import string
import pytz
import re
import json
import requests
from datetime import datetime
from dateutil import parser

tokens = {}

def load_certificates(path: string):
    """
    load certificates
    """
    with open(path, 'r') as f:
        return json.loads(f.read())


def authenticate(siteurl, region, certificates):
    """
    get authenticate info from vbrick.
    """
    token_url = f'{siteurl}/api/v2/authenticate'
    resp = requests.post(token_url, json= certificates[region])
    return resp.json()


def get_token(siteurl, region, certificates):
    """
    get token

    if token not exist or token expiration, get the token from authenticate function again.
    """
    tz = pytz.timezone('UTC')
    now = datetime.now(tz=tz)
    if region not in tokens:
        token_info = authenticate(siteurl, region, certificates)
        tokens[region] = token_info
    else:
        expira = parser.parse(tokens[region]['expiration'])
        if now > expira:
            token_info = authenticate(siteurl, region, certificates)
            tokens[region] = token_info
        
    return tokens[region]['token']