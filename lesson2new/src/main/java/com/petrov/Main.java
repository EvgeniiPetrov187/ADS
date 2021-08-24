package com.petrov;

public class Main {
    public static void main(String[] args) {

        Notebook[] arr = new Notebook[5000];
        NewArray newArray = new NewArray(arr);
        Notebook[] notebooks = newArray.getArray(arr);

        for (Notebook notebook : Sort.getSort(notebooks)) {
            System.out.println(notebook.toString());
        }

    }
}



