/*
 * 1) Упражнения с collections
 *      Создаю массив со словами, некоторые из которых повторяются
 *      1.1) вывожу список уникальных слов используя HashSet
 *      1.2) несколькими способами определяю и вывожу список слов с количеством их повторений в массиве
 * 2) Телефонная книга
 *      Телефоный справочник с парами {Фамилия: Номер} 
 *      Написать класс обеспечивающий Функционал:
 *      1) добавить абонента методом add
 *      2) искать номер телефона по фамилии методом get
 *      Примечания:
 *      В случае однофамильцев, на одну фамилию может приходится несколько телефонов
 *      Тогда get должен предоставлять все номера для заданной фамилии
 */
package java2.lesson3;

import java.util.*;
/**
 *
 * @author Gerasimov V. Gerasim
 */
public class MainClass {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //Исходный массив из 21 слова, часть из них повторяется
        ArrayList <String> list = new ArrayList <String>(Arrays.asList("Java", "Core", "JavaScript","Python","CPP",
                            "C#","PHP","Haskel","Scala","Python","Java",
                            "JavaScript","Node.js","Java","CPP","PHP",
                            "Node.js","Java","Go","Python","C#"));
        //Показываю исходный массив
        System.out.println(list);
        System.out.println();
        //Показываю уникальные слова (использу. Set - Set не может быть одинаковых элементов)
        Set <String> hs = new HashSet <>(list);
        System.out.println("Unique words:"+hs);
        //Теперь используя словарь уникальных слов из Set
        //Пройдусь с помощью Итератора по исходному массиву, для ответа на вопрос
        //сколько раз то или иное слово встречается в масиве
        int c = 0;//счётчик повторений
        
        /*        
        //Вариант 1
        for(String s:hs){//взял уникльное слово
            c = Collections.frequency(list, s);//и узнал сколько раз оно присутстввует в коллекции
            System.out.printf("%s: %d\n",s,c);
        }*/
        
        //Вариант 2
        for (String ref:hs) {//взял уникальное слово
            c = 0;//сбросил счётчик
            for(String s:list){//прошёл по массиву в поиске включений
                if (s.equals(ref)) c++;
            }
            //А вот как этот фрагмент предложила заменить NetBeans IDE:
            //c = list.stream().filter((s) -> (s.equals(ref))).map((_item) -> 1).reduce(c, Integer::sum);
            System.out.printf("%s: %d\n",ref,c);
        }
        
        System.out.printf("\nТелефонная книга\n\n");
        PhoneBook book = new PhoneBook ();
        book.add("+79139002602", "Герасимов");
        book.add("+79139002601", "Герасимов");
        book.add("+79139002600", "Герасимов");
        book.add("+79139002702", "Иванов");
        book.add("+79139002701", "Иванов");
        book.add("+79139002700", "Петров");
        System.out.println(book);//покажу всю книгу
        //Покажу конкретных людей
        System.out.println(book.get("Герасимов"));
        System.out.println(book.get("Иванов"));
        System.out.println(book.get("Петров"));
        System.out.println(book.get("Баширов"));
    }
    
}
        //Варианты котоорые к концу прохода обнулят массив слов:
        /* Вариант 3.
        for(String s:hs){//взял уникльное слово
            while (list.contains(s)){//и иду по массиву
                c++;
                list.remove(s);//удаляю "уник.слово" из итератора чтобы не мешало следующей итерации
            }
            System.out.println(s+" - "+ c);
            c = 0;
        }
        */
        
        /* //Вариант 4
        for(String s:hs){//взял уникльное слово
            Iterator<String> i = list.iterator();
            while (i.hasNext()){//и иду по массиву пока есть куда идти
                String str = i.next();//получил текущий элемент и сдвинулся к следующему
                if (str == s) {//пока текущий элемент равен уникальному слову
                    c++;//считаю счётчик
                    i.remove();//удаляю текущий элемент из итератора чтобы не мешал следующей итерации
                }
            }
            System.out.println(s+" - "+ c);
            c = 0;
        }
        */
        //System.out.println(list);