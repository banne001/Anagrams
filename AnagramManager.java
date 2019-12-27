import java.util.*;
/**
 * Anagram class to store all the words passed through the constructor
 * stores it into an Array
 * Able to sort the anagram either by form or word
 * 
 * @author Blezyl Santos
 * @version 2.27 (Feb 27 2019)
 */

public class AnagramManager{
   private Word[] anagram;
   /**
    * Anagram Manager constructor that initializes and declares the anagram
    * Goes through the List from the parameters and adds it into the anagram
    */ 
   public AnagramManager(List<String> List){
      if (List.isEmpty()) throw new IllegalArgumentException();
      anagram = new Word[List.size()];
      for(int i = 0 ; i < List.size() ; i++){
         Word temp = new Word(List.get(i));
         anagram[i] = temp;
      }
   }
   /**
    * Sorts the anagram by the word. By putting the words in a string array 
    * and sorting the string and replacing the anagram words in the order 
    * of the sorted string. the result would be the anagram sorted by words.
    */
   public void sortByWord(){
      String[] temp = new String[anagram.length];
      for (int i=0;i<anagram.length;i++){
          temp[i] = anagram[i].getWord();
      }Arrays.sort(temp);
      for(int i = 0 ; i < anagram.length; i++){
         Word tempa = new Word(temp[i]);
         anagram[i] = tempa;
      }
   }
   /**
    * Sorts the anagram words in order by the canonical form
    * Since the Word class has a compareto method it will sort itself by that method 
    */
   public void sortByForm(){   
      Arrays.sort(anagram);
   }
   /**
    * Returns the first word it encounters with same canonical form 
    * as the String given in the parameters
    *
    * @param x the word that will be compared to the list 
    * @return String the first word it encounters with same canonical form as the given String
    */
   public String getAnagram(String x){
      Word y = new Word(x);
      for (int i=0; i < anagram.length;i++){
         if(x.compareTo(anagram[i].getWord()) == 0){}
         else if(y.compareTo(anagram[i]) == 0){
            return anagram[i].getWord();
         }
      } return "";
   }
   /**
    * Returns all the words with the the same canonical form as the word passed through the 
    * parameters in a Set
    * @param x the word that will be compared to the list 
    * @return matches A set of strings containing all the words with the same canonical 
    * form as the given word.
    */
   public Set<String> getAnagrams(String x){
      Word y = new Word(x);
      Set<String> matches = new TreeSet<>();
      for (int i=0; i < anagram.length;i++){
         if(x.compareTo(anagram[i].getWord()) == 0) continue;
         else if(y.compareTo(anagram[i]) == 0){
            matches.add(anagram[i].getWord());
         }
      }return matches;
   }
   /**
    * Prints first 5 words and canonical and the last 5 words and canonical
    * @Override
    */
   public String toString(){
      String answer = "";
      for(int i=0; i<5;i++){
         answer+= anagram[i];
      }
      answer +="[...]";
      for(int i=anagram.length - 5; i<anagram.length;i++){
         answer+= anagram[i];
      }return answer;
   }
}