import java.beans.DefaultPersistenceDelegate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class OrdenaStrings {
     public static void main (String[] args){


         // METODOS DEFAULTS -  PRIMEIRO GRANDE RECURSO DO JAVA 8... PERMITE QUE VC CRIE  METODOS DEFAULTS NAS INTEFACES  E ESSE METODO SEJA CONCRETO E HERDADO.
         // DIFERENTE DA CLASSE ABSTRATA ONDE VC PODE TER ATRIBUTOS E ESTADO... E NA INTERFACE NAO SE PODE TER ESTADO.
         // ELA PODE TER METODOS CONCRETOS QUE CHAMEM METODOS ESTATICOS DE FORA OU METODOS DO PROPRIO OBJETO OU DE OBJETOS PASSADO PARA ELA COMO PARAMETRO.


         // ORDENACAO DE PALAVRAS E UTILIZACAO DE COMPARATOR
         List<String> palavras = new ArrayList<String>();
         palavras.add("alura online");
         palavras.add("editora casa do codigo");
         palavras.add("caelum");

         Comparator<String> comparador = new ComparadorPorTamanho();
         Collections.sort(palavras);
         System.out.println(palavras);
         Collections.sort(palavras, comparador);
         System.out.println(palavras);

         // NO JAVA 8 A PROPRIA INTEFFACE LIST POSSUI UM METODO SORT... E DETALHE... COM IMPLEMENTACAO CONCRETA. (NA INTERFACE - OS DEFAULT METHODS)
         palavras.sort(comparador);
         System.out.println(palavras);

///////////////////////////////////////////////////////////////////////////////////////////////////

         // LOOPS ANTES DO JAVA 8
         for (String string : palavras){
             System.out.println(string);
         }

         Consumer<String> consumidor = new ImprimeNaLinha();

         palavras.forEach(consumidor);
     }
}

class ImprimeNaLinha implements Consumer<String>{
    @Override
    public void accept(String s){
        System.out.println(s);
    }

}

class ComparadorPorTamanho implements Comparator<String> {
    @Override
    public int compare(String s1, String s2){
        if(s1.length() < s2.length())
            return -1;
        if(s1.length() > s2.length())
            return 1;
        return 0;
    }
}