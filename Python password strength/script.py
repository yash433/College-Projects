import string

def check_password_strength(password):
    # check if the password is a common password
    with open('common.txt', 'r') as f:
        common = f.read().splitlines()
    if password in common:
        print("Password was found in a common list. Score 0 / 7")
        return 0
    
    # check if the password contains at least one uppercase letter, lowercase letter,
    # special character and digit by iterating through each character and checking
    # if it belongs to the respective character set, then adding it to the list 'characters'
    characters = [
        any([c in string.ascii_uppercase for c in password]),
        any([c in string.ascii_lowercase for c in password]),
        any([c in string.punctuation for c in password]),
        any([c in string.digits for c in password])
    ]

    # get the length of the password and assign a score based on the length
    # passwords that are longer get a higher score
    length = len(password)
    score = 0
    if length > 6:
        score += 1
    if length > 9:
        score += 1
    if length > 12:
        score += 1
    if length > 15:
        score += 1
    if length > 18:
        score += 2

    # increase the score if the password contains more than one type of character
    # from the four different categories
    if sum(characters) > 1:
        score += 1
    if sum(characters) > 2:
        score += 1
    if sum(characters) > 3:
        score += 1
    if sum(characters) > 4:
        score += 2
    return score

password = input("Enter your password: ")
if ' ' in password:
    print("Your password can not contain space")
else:
    score = check_password_strength(password)
# print out the score of the password and a message indicating its strength
    if score< 4:
        print(f"The password is quite weak! Score: {str(score)} / 7")
    elif score == 4:
        print (f"The password is ok! Score : {str(score)} / 7")
    elif 4 < score <= 6:
        print(f"The password is pretty good! Score: {str(score)} / 7")
    elif score > 6:
        print (f"The password is strong! {str(score)} / 7")

