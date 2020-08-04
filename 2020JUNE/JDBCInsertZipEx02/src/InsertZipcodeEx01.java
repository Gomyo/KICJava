import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class InsertZipcodeEx01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BufferedReader br = null;
		BufferedWriter bw = null;
		try {
			br = new BufferedReader( new FileReader( ".\\zipcode_seoul_utf8_type3.csv" ) );			
			bw = new BufferedWriter( new FileWriter( ".\\zipcode_seoul_utf8_type3.sql" ) );
			String address = null;
			
			while( ( address = br.readLine() ) != null ) {
				String[] addresses = address.split( "," );
				
				String sql = String.format("insert into zipcode values ('%s', '%s', '%s', '%s', '%s', '%s', %s);", addresses[0], addresses[1], addresses[2], addresses[3], addresses[4], addresses[5], addresses[6] );

				bw.write( sql );
				bw.newLine();
			}
			
			System.out.println( "완료" );
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println( "[에러] " + e.getMessage() );
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println( "[에러] " + e.getMessage() );
		} finally {
			if( br != null ) try { br.close(); } catch( IOException e ) {}
			if( bw != null ) try { bw.close(); } catch( IOException e ) {}
		}
	}
}
