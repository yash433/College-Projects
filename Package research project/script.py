from textblob import TextBlob

def file_content(filename):
    t = open(filename)
    tt = t.read()
    return tt

#connect textblob, text, and sentences above
blob = TextBlob(file_content("demofile.txt"))
sentences = blob.sentences
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