
from os import sep
from tkinter import N
from person import Person

people_list =  [Person('Robert', 'Johnson', 15), 
                Person('Bob', 'Robby', 18),
                Person('John', 'Smith', 25)]
print(*people_list, sep = '\n\n')

#for x in people_list:
   # age_desc = 'Adult'
   # if x.isMinor(): age_desc = 'Minor'
   # print(f"{x.first_name} {x.last_name} is a {age_desc}")
   # print(*people_list)
    
    

