import nltk
from nltk.corpus import treebank

sentence = """Your big opportunity is flying out of here"""
tokens = nltk.word_tokenize(sentence)
tagged = nltk.pos_tag(tokens)
entities = nltk.chunk.ne_chunk(tagged)
#t = treebank.parsed_sents('wsj_0001.mrg')[0]

print(tagged)
entities.draw()

