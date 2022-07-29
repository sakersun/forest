from time import sleep
import pyautogui

while True:
    pyautogui.moveTo(300, 400, duration=5)
    pyautogui.click()
    pyautogui.moveTo(300, 500, duration=5)
    pyautogui.click()