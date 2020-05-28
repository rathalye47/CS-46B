package dna;

import java.io.*;

//
// Reads lines from a BufferedReader and builds a FastqRecord.
//
public class FastqReader {

	private BufferedReader theBufferedReader;

	//
	// Constructs a FastqReader with the given BufferedReader.
	//
	public FastqReader(BufferedReader aBufferedReader) {
		theBufferedReader = aBufferedReader;
	}

	// Returns the next record in the file, or null if EOF (end-of-file).
	public FastqRecord readRecord() throws IOException, RecordFormatException {

		// Reads the defline from the BufferedReader. Returns null if you read null,
		// indicating end of file.
		String line1 = theBufferedReader.readLine();

		if (line1 == null) {
			return null;
		}

		// Reads the next 3 lines from the buffered reader. Constructs and returns a
		// FastqRecord.
		String line2 = theBufferedReader.readLine();
		String line3 = theBufferedReader.readLine();
		String line4 = theBufferedReader.readLine();
		FastqRecord fqRecord = new FastqRecord(line1, line2, line4);
		return fqRecord;
	}
}
