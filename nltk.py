#!/usr/bin/env python
# -*- coding: utf-8 -*-

import sys
import nltk

MIN_CORPORA = [
    'rslp',
    'stopwords'
]

def download_lite():
    for each in MIN_CORPORA:
        nltk.download(each)


def main():
    download_lite()
    print("Finished.")

if __name__ == '__main__':
    main()
