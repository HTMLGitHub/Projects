age = int(input("How old are you?\n"))

decade = age // 10
year = age % 10


def print_hi(decades, years):
    # Use a breakpoint in the code line below to debug your script.
    print(f'You are {decades} decades and {years} years old')  # Press Ctrl+F8 to toggle the breakpoint.


# Press the green button in the gutter to run the script.
if __name__ == '__main__':
    print_hi(decade, year)

# See PyCharm help at https://www.jetbrains.com/help/pycharm/
