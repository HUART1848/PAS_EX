
// Niveau 1

// 1.
var nom = ""
var prenom = ""

// 2.
nom = "Huart"
prenom = "Hugo"

// 3.
// val dateDeNaissance = ""
// dateDeNaissance = "19.01.2001" Pas posssible car val = immuable
var dateDeNaissance = "19.01.2001"

// 4.
val msg = s"Bonjour, je m'apelle $prenom $nom et je suis né le $dateDeNaissance" 
println(msg)

// 5.
var compteur = 0
while compteur < 5 do
    println(msg)
    compteur += 1

// 6.
for _ <- 1 to 5 do
    println(msg)

// 7.
for _ <- 0 to 4 do
    println(msg)

// 8.
println(if compteur == 0 then nom else prenom)

// 9.
compteur match
    case 0 => println(nom)
    case _ => println(prenom)


// Niveau 2

// 10.
var i = 1
while i < 100 do
    if i % 2 == 1 && (i % 3 == 0 || i % 5 == 0) then
        println(i)
    i += 1

for i <- 1.to(100) if i % 2 == 1 && (i % 3 == 0 || i % 5 == 0) do println(i)

// 11.
def func(a: Int, b: Int) = println(if a > b then a else b)
func(3, 5)

// 12.
def f2(s: String) = s match
    case "Hello" => println("World")
    case "World" => println("Hello")
    case _ => println("Goodbye")

// 13.
for i <- 1.to(4 * 4 * 3) do
    println("Hello World !")

// 14.
def f3(s: String) = s match
    case x if x.length() % 2 != 0 => println(x.length())
    case "Hello World!" => println(s)
    case _ => println("Goodbye")

// 15.
i = 0
compteur = 0
while compteur < 10 do
    compteur = compteur match
        case c if c % 2 == 0 => compteur + 3
        case _ => compteur + 1
    i += 1

println(i)
println(compteur)

// 16.
def f4(x: Int): Int = x match
    case a if a > 100 => x
    case a if a % 7 == 0 => f4(x + 8)
    case a if a % 2 != 0 => f4(x + 12)
    case a => f4(x + 1)

// 109 est la nouvelle valeur de x
// f4 reçoit les valeurs suivantes au fil des 11 appels
// 0, 8, 9, 21, 29, 41, 53, 65, 77, 85, 97, 109
// Étant donné que f4 est récursive, il faut préciser son type de retour Int
var x = 0
f4(x)

// 17.
def f5(x: Int, y: Int, z: Int) = z match
    case 0 => x * x + y * y + (x + y) * (x + y)
    case a if a % 2 == 0 => x * x + y * y
    case a if a % 2 != 0 => (x + y) * (x + y)

f5(2, 3, 1)
f5(2, 3, 2)
// Pas correct si "case 0 ..." est en dernier dans f5, car la branche "z pair" va matcher avant
f5(2, 3, 0) 

// 18.

def f6(x: Int, y: Int): Int =
    if x == y then return x // A
    else if x < y then
        if x > 4 then return 42 // B
        else return y // C
    else if x > y then
        if y % 2 != 0 && x % 2 == 0 then return 4 * x - 7 * y // D
        else if x % 3 == 0 && y % 4 == 0 then return x * x + y * y // E
        else if x % 2 != 0 then return 2 * x + 3 * y // F
    return 9 // G

f6(0, 0) // A
f6(5, 9) // B
f6(1, 3) // C
f6(4, 1) // D
f6(9, 4) // E
f6(5, 2) // F
f6(4, 2) // G

def f7(x: Int, y: Int): Int = (x, y) match
    case (a, b) if a == b => a
    case (a, b) if a < b => if x > 4 then 32 else b
    case (a, b) if a > b => 