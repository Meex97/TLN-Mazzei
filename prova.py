import nltk
from nltk import load_parser


#sentence = 'Angus gives a bone to every dog'.split()
#sentence = 'a dog bites Irene'.split()
#sentence = 'You are imagining things'.split()
sentence = 'There is a price on my head'.split()
#tokens = nltk.word_tokenize(sentence)
print(sentence)

#tagged = nltk.pos_tag(tokens)
cp = load_parser('cfgrammar2.fcfg', trace=1)

#nltk.data.load('cfgrammar.fcfg')

for tree in cp.parse(sentence):
    print(tree)


