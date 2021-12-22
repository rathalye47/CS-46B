package dna;

//
// FastaRecord contains the defline and sequence from a record in a fasta file.
//
public class FastaRecord implements DNARecord {

	private String defline;
	private String sequence;

	//
	// Constructs a FastaRecord with the given defline and sequence.
	// Throws a RecordFormatException if the 1st char of the defline is not '>'.
	//
	public FastaRecord(String theDefline, String theSequence) throws RecordFormatException {
		sequence = theSequence;
		char deflineCharacter = theDefline.charAt(0);

		if (deflineCharacter != '>') {
			throw new RecordFormatException(
					"Bad 1st char in defline in fasta record: saw " + deflineCharacter + ", expected >");
		}

		defline = theDefline;
	}

	//
	// Initializes the defline and sequence from the input record.
	//
	public FastaRecord(FastqRecord fastqRec) {
		defline = ">" + fastqRec.getDefline().substring(1);
		sequence = fastqRec.getSequence();
	}

	//
	// Returns the defline.
	//
	public String getDefline() {
		return defline;
	}

	//
	// Returns the sequence.
	//
	public String getSequence() {
		return sequence;
	}

	//
	// Checks for deep equality of the defline and sequence instance variables.
	//
	public boolean equals(Object obj) {
		FastaRecord other = (FastaRecord) obj;
		return this.defline.equals(other.defline) && this.sequence.equals(other.sequence);
	}

	//
	// Returns the sum of the hashcodes of defline and sequence.
	//
	public int hashCode() {
		return defline.hashCode() + sequence.hashCode();
	}
}
