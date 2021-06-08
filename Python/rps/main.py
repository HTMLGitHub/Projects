import random

computer_choice = random.choice(['scissors', 'rock', 'paper'])


def print_hi(choice):
    user_choice = input('Do you want - rock - paper - scissors?\n')
    print(f'Computer chose {choice}')
    if choice == user_choice:
        print("TIE")
    elif user_choice == 'rock' and choice == 'scissors':
        print("WIN")
    elif user_choice == 'scissors' and choice == 'paper':
        print("WIN")
    elif user_choice == 'paper' and choice == 'rock':
        print("WIN")
    else:
        print("LOSE")


# Press the green button in the gutter to run the script.
if __name__ == '__main__':
    print_hi(computer_choice)

# See PyCharm help at https://www.jetbrains.com/help/pycharm/
