package dna;

import java.io.*;
import java.util.*;

//
// Converts a fastq file to a fasta file using a FileConverter.
//
public class FileConverter {

	private File fastq;
	private File fasta;

	//
	// Constructs a FileConverter with the given fastq and fasta files.
	//
	public FileConverter(File theFastq, File theFasta) {
		fastq = theFastq;
		fasta = theFasta;
	}

	//
	// Writes a fasta file consisting of conversion of all records from the fastq
	// with sufficient quality and unique defline.
	//
	public void convert() throws IOException {

		// Builds a chain of readers.
		FileReader fr = new FileReader(fastq);
		BufferedReader br = new BufferedReader(fr);
		FastqReader fqr = new FastqReader(br);

		// Builds a chain of writers.
		FileWriter fw = new FileWriter(fasta);
		PrintWriter pw = new PrintWriter(fw);
		FastaWriter faw = new FastaWriter(pw);

		// Reads, translates, and writes.
		boolean finished = false;
		while (!finished) {
			try {
				FastqRecord fqRecord = fqr.readRecord();

				if (fqRecord == null) {
					finished = true;
				}

				else {
					if (!fqRecord.qualityIsLow()) {
						FastaRecord faRecord = new FastaRecord(fqRecord);
						faw.writeRecord(faRecord);
					}
				}
			}

			catch (RecordFormatException rfException) {
				System.out.println(rfException.getMessage());
			}
		}

		// Closes fr, br, fw, and pw in reverse order of creation.
		pw.close();
		fw.close();
		br.close();
		fr.close();
	}

	// Reads and converts the fastq file that we downloaded for this assignment.
	public static void main(String[] args) {
		System.out.println("Starting");
		try {
			File fastq = new File("data/HW4.fastq");
			if (!fastq.exists()) {
				System.out.println("Can't find input file " + fastq.getAbsolutePath());
				System.exit(1);
			}
			File fasta = new File("data/HW4.fasta");
			FileConverter converter = new FileConverter(fastq, fasta);
			converter.convert();
		} catch (IOException x) {
			System.out.println(x.getMessage());
		}
		System.out.println("Done");
	}
}
