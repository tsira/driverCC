/**
 * fileReader helper class
 * This class will take a text file in standard FASTA format and parse it into Header Lines and Sequence Reads
 *
 * Created by tsira on 12/19/2016.
 */

import java.io.*;
import java.util.*;

public class fastaReader {

    private String [] description;
    private String [] sequence;

    public fastaReader(String filename)
    {
        readFile(filename);
    }

    void readFile(String file)
    {
        List fastaHeader= new ArrayList();
        List seqs = new ArrayList();
        try{
            BufferedReader in     = new BufferedReader( new FileReader( file ) );
            StringBuffer   buffer = new StringBuffer();
            String line   = in.readLine();

            if( line == null )
                throw new IOException( file + " is an empty file" );

            if( line.charAt( 0 ) != '>' )
                throw new IOException( "First line of " + file + " should start with '>'" );
            else
                fastaHeader.add(line);
            for( line = in.readLine().trim(); line != null; line = in.readLine() )
            {
                if( line.length()>0 && line.charAt( 0 ) == '>' )
                {
                    seqs.add(buffer.toString());
                    buffer = new StringBuffer();
                    fastaHeader.add(line);
                } else
                    buffer.append( line.trim() );
            }
            if( buffer.length() != 0 )
                seqs.add(buffer.toString());
        }catch(IOException e)
        {
            System.out.println("Error when reading "+file);
            e.printStackTrace();
        }

        description = new String[fastaHeader.size()];
        sequence = new String[seqs.size()];
        for (int i=0; i< seqs.size(); i++)
        {
            description[i]=(String) fastaHeader.get(i);
            sequence[i]=(String) seqs.get(i);
        }

    }

    //return first sequence as a String
    public String getSequence(){ return sequence[0];}

    public int getNumberofReads() {return sequence.length;}

    //return first xdescription as String
    public String getDescription(){return description[0];}
    //return sequence as a String
    public String getSequence(int i){ return sequence[i];}

    //return description as String
    public String getDescription(int i){return description[i];}


}
