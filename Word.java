import java.util.*;
/**
 * Word class that has the original and the canonical form of the word.
 * Also implements comparable to compare the string of the canonical word to the other
 * word canonical.
 * 
 * @author Blezyl Santos
 * @version 2.27 (Feb 27 2019)
 */

public class Word implements Comparable<Word>{
   private String original;
   private String canonical;
   
   /**
    * Word constructor that initializes and declares the original word as the 
    * string passed through the parameters and stores the canonical version of the word
    */
   public Word(String x){
      x= x.toLowerCase();
      this.original = x;
      char[] charac = x.toCharArray();
      Arrays.sort(charac);
      this.canonical = String.valueOf(charac);
   }
   /**
    * @return original the original word 
    */
   public String getWord(){
      return original;
   }
   /**
    * @return canonical the canonical of the word
    */ 
   public String getForm(){
      return canonical;
   }
   /**
    * Prints the original and canonical word
    * @Override
    */
   public String toString(){
       return "["+original + "=" + canonical+"]";
   }
   /**
    * compares the canonical form between the original and the word passed
    * through the parameters by using the compareto method of strings.
    */
   public int compareTo(Word other){
      return canonical.compareTo(other.getForm());
   }
}