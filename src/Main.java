/*@auth tsira
*/
import java.util.*;

public class Main {
    /*@pre file name of input fasta file is called so that the method can be invoked
     *,

        As a part of our interview loop, we ask that you complete the following coding challenge:

        Introduction:

        To sequence the DNA for a given individual we typically fragment each chromosome to many small pieces that can be sequenced in parallel and then re-assemble the sequenced fragments into one long DNA sequence. In this task we ask that you take on a specific subtask of this process.

        Challenge:

        The input to the problem is at most 50 DNA sequences (i.e, the character set is limited to T/C/G/A) whose length does not exceed 1000 characters. The sequences are given in FASTA format (https://en.wikipedia.org/wiki/FASTA_format). These sequences are all different fragments of one chromosome.

        The specific set of sequences you will get satisfy a very unique property:  there exists a unique way to reconstruct the entire chromosome from these reads by gluing together pairs of reads that overlap by more than half their length. An example set of input strings is attached.

        The output of your program should be this unique sequence that contains each of the given input strings as a substring.

        In addition to the code you wrote, we also ask for a README describing your general approach as well as any additional code you wrote to evaluate your solution. We would prefer your code to be written in Python, Go, Scala, Javascript, or Java.

        Example input:

        >Frag_56
        ATTAGACCTG
        >Frag_57
        CCTGCCGGAA
        >Frag_58
        AGACCTGCCG
        >Frag_59
        GCCGGAATAC

        Example output:

        ATTAGACCTGCCGGAATAC

    */

    /*
    * The Algorithm will need to injest [x] number of sequences of [y] length, and compare each sequence to every other
    * sequence to determine the number of characters that they overlap.
    *
    * If this length of overlap is greater than the half the length of the sequence string then it is considered a valid
    * match and the sequences can be overlapped.
    *
    * Finally the single master contig will need to be output.
    *
    * From the example:
    *
    *                                         ATTAGACCTGCCGGAATAC
    *                                      56 ATTAGACCTG
    *                                      57       CCTGCCGGAA
    *                                      58    AGACCTGCCG
    *                                      59          GCCGGAATAC
    *
    *
    * */

    public static void main(String[] args) {
        String workingDir = System.getProperty("user.dir");
        System.out.println("Initializing Driver Coding Challenge" + "\n\n Specify File Name (Default example_driver.fasta)\n");


        final fastaReader importFile = new fastaReader(workingDir+"\\src\\example_driver.fasta");
        importFile.getSequence(1);
        int numberofSeqs = importFile.getNumberofReads();
        System.out.println(" There are " + numberofSeqs + " sequence fragments in the file");

        if(numberofSeqs < 2)
        {
            System.out.println("There are fewer than 2 sequences contained within the input file. No matching can occur");
        }
        else {

            for (int i = 0; i < numberofSeqs; i++) {
                System.out.println("Seq "+ i+ " "+ importFile.getSequence(i)+"");
            }
        }

        int imatchArray[][] = new int[numberofSeqs][numberofSeqs];

        String lscOutput = lcs.LCSAlgorithm(importFile.getSequence(0), importFile.getSequence(1));

        System.out.println("'"+importFile.getSequence(0)+"' '"+importFile.getSequence(1)+"' = ["+lscOutput+"]");

//        for (int i = 0; i < numberofSeqs; i++) {
//            for (int j = 0; j < numberofSeqs; j++){
//                imatchArray[i][j] = lcs.LCSAlgorithm(importFile.getSequence(i), importFile.getSequence(j));
//                System.out.print("["+imatchArray[i][j]+"]");
//            }
//            System.out.println();
//        }
//
//        int bmatchArray[][] = new int[numberofSeqs][numberofSeqs];
//
//        for (int i = 0; i < numberofSeqs; i++) {
//            for (int j = 0; j < numberofSeqs; j++){
//                if( i == j ){
//                    bmatchArray[i][j] = 0;}
//                else if (imatchArray[i][j] > 5 ){
//                    bmatchArray[i][j] = 1;
//
//                    String seq1 = importFile.getSequence(i);
//                    String seq2 = importFile.getSequence(j);
//
//                }
//
//                else{
//                    bmatchArray[i][j] = 0;}
//
//                System.out.print("["+bmatchArray[i][j]+"]");
//            }
//            System.out.println();
//        }





        //System.out.println(fibDP(6) +"Fib");
        //https://github.com/sanger-pathogens/assembly-stats/blob/master/fasta.cpp

    }

//    public static int fibDP(int x) {
//        int fib[] = new int[x + 1];
//        fib[0] = 0;
//        fib[1] = 1;
//        for (int i = 2; i < x + 1; i++) {
//            fib[i] = fib[i - 1] + fib[i - 2];
//        }
//        return fib[x];
//    }
}
