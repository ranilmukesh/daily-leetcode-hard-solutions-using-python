def randomarray():
    from numpy import random

x = random.randint(99999, size=(90,10))  # size = (rows, columns)
y = random.randint(99999, size=(90,10))  # 99999 used here is limit , which will generate random numbers under 99999 for the required matrix
z = random.randint(99999, size=(900))    # this generates 900 random numbers under 99999

a = (repr(x))  #this changes the numpy output to array datatype(lists)
b = (repr(y))
c = (repr(z))

print(f"matrix a = {a}")
print(f"matrix b = {b}")
print(f"matrix c = {c}")

# generate random arrays using numpy library with desired no.of columns and rows
#size = (row,columns)
