import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class OrdenaStringsClasseAnonima {
    public static void main(String[] args) {


        //  CLASSES ANONIMAS: REALMENTE NAO TEM NOME.
        //  FICA ESCONDIDA DENTRO DA CLASSE.
        //  USAMOS QUANDO QUEREMOS IMPLEMENTAR INTERFACES MUITO CURTAS QUE IMPLEMENTAM POUCOS METODOS.
        //  E EM ESPECIAL QUANDO NAO VAMOS REAPROVEITAR ESSE CODIGO.
        //  MUITO UTILIZADA PARA IMPLEMENTAR LISTENERS E CALL BACKS
        //


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


///////////////////////////////////////////////////////////////////////////////////////////////////
//              CLASSE ANONIMA SENDO USADA. O METODO ACCEPT FOI SOBRECARREGADO E EXECUTADO NO MOMENTO
//              QUE O FOREACH FOR CHAMADO.
///////////////////////////////////////////////////////////////////////////////////////////////////
        Consumer<String> consumidor = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };

        palavras.forEach(consumidor);

///////////////////////////////////////////////////////////////////////////////////////////////////
//              AO INVES DE SOBRECARREGAR O METODO E DEPOIS ITERA-LO... PODEMOS PASSAR A CLASSE
//              ANONIMA COMO PARAMETRO PARA O FOREACH...
///////////////////////////////////////////////////////////////////////////////////////////////////

        palavras.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });
        // NESTE CASO NAO PRECISO MAIS DA VARIAVEL TEMPORARIA "consumidor"

///////////////////////////////////////////////////////////////////////////////////////////////////
//              INTROCUCAO AO LAMBDAS... FACILIDADE E LEGIBILIDADE NA ESCRITA DO METODO.
///////////////////////////////////////////////////////////////////////////////////////////////////

        palavras.forEach((String s) -> {
            System.out.println(s);
        });
        // A SETINHA É COMO SE FOSSE O SIMBOLO DO LAMBDA.INDICANDO A ACAO QUE SERA FEITA NO
        // MOMENTO DE EXECUCAO DO FOREACH

///////////////////////////////////////////////////////////////////////////////////////////////////
        //COMO O LAMBDA SO RECEBE UM ARGUMENTO ( O METODO ACCEPT DO CONSUMER)... NAO PRECISO ESPECIFICAR
        // NAO É OBRIGADORIO USAR OS PARENTESES. E TAMBEM NAO É PRECISO FALAR O TIPO PORQUE ELE INFERE
        // SE DENTRO DAS CHAVES SO EXISTE UM COMANDO... NAO É OBRIGADO COLOCAR CHAVES E NEM O PONTO E VIRGULA

        palavras.forEach(s -> System.out.println(s));
        // PARA CADA PALAVRA ´S´ IMPRIMA ´S´


///////////////////////////////////////////////////////////////////////////////////////////////////
//                                   COMPARADOR POR TAMANHO                                      //
//////////////////////////////////////////////////////////////////////////////////////////////////


///////////////////////////////////////////////////////////////////////////////////////////////////

///////////////////////////////////////////////////////////////////////////////////////////////////
        class ComparadorPorTamanho implements Comparator<String> {
            @Override
            public int compare(String s1, String s2) {
                if (s1.length() < s2.length())
                    return -1;
                if (s1.length() > s2.length())
                    return 1;
                return 0;
            }
        }

        ///////////////////////////////////////////////////////////////////////////////////////////////////
        // AQUI COM O COMPARATOR A MESMA COISA... POSSO PASSAR COMO CLASSE ANONIMA...


        palavras.sort(new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                if (s1.length() < s2.length())
                    return -1;
                if (s1.length() > s2.length())
                    return 1;
                return 0;
            }
        });

        System.out.println(palavras);

///////////////////////////////////////////////////////////////////////////////////////////////////
// AOU USAR O RECURSO DO LAMBDA MAIS UMA VEZ PARA SIMPLIFICAR A LEGIBILIDADE DO CODIGO.
// ELE FUNCIONA SEMPRE QUE SE TEM UMA INTERFACE QUE SOMENTE TEM UM METODO ABSTRATO.
//
// ISSO SE CHAMA INTERFACE FUNCIONAL...

        palavras.sort((s1, s2) -> {       // nao precisa do tipo pq ele consegue inferir, os parenteses sao necessarios pq existe mais de um argumento
            if (s1.length() < s2.length())
                return -1;
            if (s1.length() > s2.length())      // como existe mais de um statemant, as chaves se tornam necessarias
                return 1;
            return 0;
        });


//////////////////////////////////////////////////////////////////////////////////////////////////
        // EXISTE UM METODO  ESTATICO EM INTEGER QUE JÁ TEM UMA ASSINATURA PARECIDA...


        palavras.sort((s1, s2) -> {
            return Integer.compare(s1.length(), s2.length());
        });

// MAS PODE FICAR AINDA MAIS SUSCINTO... COMO NESTE CASO PASSOU A TER SOMENTE UM STATEMANT... PODEMOS SUPRIMIR
// AS CHAVES E PONTO E VIRGULA


        palavras.sort((s1, s2) -> Integer.compare(s1.length(), s2.length()));

        // EQUIVALENTE À ISTO:

        Consumer<String> impressor = s -> System.out.println(s);
        palavras.forEach(impressor);

        // impressor  = dada uma String ´s´, pegue essa String s e faça System.out.print dela.

/** COMO ELE INFERE O TIPO NA MAIORIA DOS CASOS... NEM PRECISAMOS DO RETURN...
O LAMBDA CONSEGUE SER CONVERTIDO PARA UMA INTERFACE FUNCIONAL.

 A EXPRESSAO LAMBDA NAO É UMA CLASSE ESPECIAL..

 O RETORNO PRECISA SER UMA INTERFACE FUNCIONAL... NAO SE PODE JOGAR UMA EXPRESSAO LAMBDA NUMA CLASSE OBJECT
 POR EXEMPLO...
 
*/


    }

}