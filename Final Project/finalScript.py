from textblob import TextBlob

def file_content(filename):
    t = open(filename)
    tt = t.read()
    return tt

#connect textblob, text, and sentences above
blob = TextBlob(file_content("demofile.txt"))
sentences = blob.sentences

#This is suppose to be my translation feature, but it does not work because Google stopped the service
'''
if (blob.detect_language() != 'en'):
    print(blob.translate(to='en'))
'''

for x in sentences:
    print(x)
#gives polairty number for each sentence
for sentence in blob.sentences:
    print('Sentence Polarity')
    print(sentence.sentiment.polarity)

#gives sentiment (polairty & subjectivity) to the entire review
print(blob.sentiment)

#identifies and prints ONLY noun phrases that help restaurants search for key words in reviews easily
print('Noun Phrases:')
print(blob.noun_phrases)


