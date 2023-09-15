# Import the Natural Language Toolkit (nltk) library for text processing.
import nltk
# Import the Article class from the newspaper library for extracting article content from a URL.
from newspaper import Article
# Import the gTTS (Google Text-to-Speech) class from the gtts library for converting text to speech.
from gtts import gTTS
# Define a function named text_to_speech that takes a URL as input.
def text_to_speech(url):
   # Create an Article object and initialize it with the provided URL.
   article = Article(url)

   # Download the content of the article from the URL.
   article.download()
   
   # Parse the downloaded article content.
   article.parse()
   
   # Download the 'punkt' tokenizer models used by NLTK for sentence and word tokenization.
   nltk.download('punkt')
   
   # Perform natural language processing tasks on the parsed article content.
   article.nlp()
   
   # Extract the text of the article.
   article_text = article.text
   
   # Define the language for the text-to-speech conversion (English in this case).
   language = 'en'
   
   # Create a gTTS object with the article text, chosen language, and disable the "slow" option.
   my_obj = gTTS(text=article_text, lang=language, slow=False)
   
   # Save the generated speech as an MP3 file named "read_article.mp3".
   my_obj.save("read_article.mp3")

# Check if the script is being run as the main program.
if __name__ == '__main__':
   # Call the text_to_speech function with a specific URL as input.
   text_to_speech(
       url='https://www.computerworld.com/article/3704812/should-you-upgrade-to-windows-11.html'
   )
