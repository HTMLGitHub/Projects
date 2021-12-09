# Simple pong game in Python 3 for beginners

import turtle

wn = turtle.Screen()
wn.title("Pong by Matthew Lee")
wn.bgcolor("black")
wn.setup(width=800, height=600)
wn.tracer(0)

# Paddle A
paddle_a = turtle.Turtle()
paddle_a.speed(0)
paddle_a.shape("square")
paddle_a.color("white")
paddle_a.penup()
paddle_a.goto(-350, 0)

# Paddle B
paddle_b = turtle.Turtle()
# Ball

# main game loop
while True:
    wn.update()

# if __name__ == '__main__':
#    print_hi('PyCharm')

