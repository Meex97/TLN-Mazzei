import nltk
from nltk import load_parser

sentence = 'a dog bites Irene'.split()
#sentence = 'Irene walks a dog'.split()
#tokens = nltk.word_tokenize(sentence)
print(sentence)

#tagged = nltk.pos_tag(tokens)
cp = load_parser('cfgrammar.fcfg', trace=0)

#nltk.data.load('cfgrammar.fcfg')

for tree in cp.parse(sentence):
    print(tree)
