# OOP_Ex1

The project is a representation of a Complex function and Visual representation of a collection of Functions.  
The complex function is in a format of the following rules:  
Operation(left function, right function)  
Where Operation is a mathematical operation from the following list:  
Plus - Computes and returns the Y value of (left function + right function) at the point X.  
mul - Computes and returns the Y value of (left function * right function) at the point X.  
div - Computes and returns the Y value of (left function / right function) at the point X.  
max - Computes and returns the Y value of max(leftFunction(x),rightFunction(x)).  
min - Computes and returns the Y value of min(leftFunction(x),rightFunction(x)).  
comp - Computes and returns the Y value of (leftfunction(rightfunction(x)),Computes the Y value of   rightfunction at the point X and computes this Value as the x for the left function.  
none - Only viable if right function Is NULL so it returns the value Y of leftFucntion at the point x.  
Left function and right function are both a functions, they can represent the Mathematical Monom , Polynom   or another ComplexFunciton.  
Explanations about Monoms and Polynoms  are given later in the ReadMe.  
 Functions_GUI Is a class with a collection of Functions.  
This collection of function have basic collection operations, and 4 additional operations.  
initFromFile - with a given String path to a file , it will read the file in the following format:  
each line will start reading the fucntion when it finds a f(x):  
f(x)= "some sort of a fucntion"  
or if f(x) is not present it will read the whole line therfor it should have a valid form of a function.  
The method initFromFile will read each line and add it to the collection of function.  
the function should be a valid form of a function.  
saveToFile - with  a given String path to a file, it will create or override a file given and write into the   file each function in a separate line in the format of:  
f(x) = "some sort of a function"  
drawFunctions - with given parameters of Width,height, range for x, range for Y and resolution, it will   create a new JFrame with the given parameters and draw X-axis in the range, Y-axis in the range and the   squares panel than it will draw all the functions in the collection with a random generated color, it will   also write into console the Color used and the function.  
Another way to receive the parameters is via a JSON file.  
with a given JSON file path it will read the parameters of width,height,Resolution,Range_x (which is an 1x2   array),Range_y (which is a 1x2 array).  
if any of the of the following doesn't exist in the JSON it will use the default following parameters for   the missing parameter.  
Width=1000  
Height=600  
Resolution=200  
Range_X = {-10,1}  
Range_Y = {-5,15}  

 

