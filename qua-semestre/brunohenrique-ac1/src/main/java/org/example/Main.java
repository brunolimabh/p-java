package org.example;

public class Main {
    public static void main(String[] args) {
        Repository repo = new Repository();
        repo.addAtEnd('c');
        repo.addAtEnd('t');
        repo.addAtEnd(' ');
        repo.addAtEnd('t');
        repo.addAfterSpace('h');
        repo.addAtIndex(2, 'p');
        repo.duplicateValue('t');
        repo.removeDuplicate('t');
        repo.show();
        System.out.println(repo.countWords());
    }
}