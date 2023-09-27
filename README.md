# Parking Lot System

# DESIGN SMELLS:

- **Rigidity**: Strange naming of classes and variables, and inconsistent use of upper and lower case letters. For example: in class ´TotalTime´ some variables start with uppercase letter and the parameters of the constructor are not camelCase (`public static int[] CalculateTime(String enterdate, String exitdate, String entertime, String exittime)` and `int Days = daysInMonth - firstDay; int MinutesInFirstDay = 0;`). Examples of strange naming is found in the class ´ParkingSpot´: (`public int si()` and `public void sipe()`).

- **Fragility**: Almost all object-data are set to public. Only in ´ParkingTicket´ info related to card numbers are privated. This is a security issue. Also, in the class ´ParkingSpot´ there are a lot of setters and getters, but they are not used. For example: (`public void setSpotNumber(int spotNumber) { this.spotNumber = spotNumber; }` and `public int getSpotNumber() { return spotNumber; }`).

- **Immobility**: Class ´RandomInfo´neglects the purpose of some other classes. Gets car and ticket info from class ´RandomInfo´instead of the objects that are supposedly created even though claims to collect from class ´Car´. This is found in the class ´ParkingLot´ on the lines 25-35.

- **Viscosity**: When thinking about changing any part of the code, I feel like writing the whole thing from start. "When a change is needed, you are tempted to hack rather than to preserve the original design."

- **Needless Complexity**: In the 'TotalTime', there is 280 lines of code for checking the time difference between beginning of the parking and leaving. This can be done much simplier and with less lines of code.

- **Needless Repetition**: In the ´TotalTime´ class there are a lot of repetition when handling the ´entertime´ and ´exittime´ variables. Almost same code repeating when handling same and different months, and inside of these if/else statements are again repetition on for a single day, one day difference and others.

- **Opacity**: Hard to understand the whole program and how to use it. In the class ´ParkingLot´ are many question marks, like bad english and nonintuitive inputs. User is not guided towards wanted inputs. To be able to use the program, user has to read the source code and check the possible outcomes on different inputs. And even when the source code is open, it is hard to navigate through. For example: (`System.out.print("You want to parked your vehicle : ");` `String userinput = scan.nextLine(); int size = userinput.length(); if (size == 5)`)

# DESIGN PRINCIPLES: NÄÄ ON GITHUB COPILOTIN EHDOTTAMIA, EN OO KÄYNY VIELÄ LÄPI JA ETSINYT OIKEITA ESIMERKKEJÄ

- **Single Responsibility Principle**: The class ´ParkingLot´ has a lot of responsibilities. It handles about everything. "A class should have only one reasont to change."

- **Open/Closed Principle**: The class ´ParkingLot´ is not open for extension. It is not possible to add new parking spots, new parking spot types, new parking spot sizes, etc... ´ParkingLot´is not closed for modification either. It is possible to change the parking spot types, sizes, etc... but it is not easy to do it. "Software entities should be open for extension, but closed for modification."

- **Liskov Substitution Principle**: The class ´ParkingLot´ is not substitutable for its subclasses. "Objects in a program should be replaceable with instances of their subtypes without altering the correctness of that program."

- **Dependency Inversion Principle**: The class ´ParkingLot´ is not dependent on abstractions. "High-level modules should not depend on low-level modules. Both should depend on abstractions."

- **Interface Segregation Principle**: The class ´ParkingLot´ is not segregated. "Many client-specific interfaces are better than one general-purpose interface."
