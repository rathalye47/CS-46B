package dna;

//
// FastqRecord contains the defline, sequence, and quality string from a record in a fastq file.
//
public class FastqRecord implements DNARecord {

	private String defline;
	private String sequence;
	private String quality;

	//
	// Constructs a FastqRecord with the given defline, sequence, and quality.
	// Throws a RecordFormatException if the 1st char of the defline is not '@'.
	//
	public FastqRecord(String theDefline, String theSequence, String theQuality) throws RecordFormatException {
		sequence = theSequence;
		quality = theQuality;
		char deflineCharacter = theDefline.charAt(0);

		if (deflineCharacter != '@') {
			throw new RecordFormatException(
					"Bad 1st char in defline in fastq record: saw " + deflineCharacter + ", expected @");
		}

		defline = theDefline;
	}

	// Returns the defline.
	public String getDefline() {
		return defline;
	}

	// Returns the sequence.
	public String getSequence() {
		return sequence;
	}

	//
	// Checks for deep equality of the defline, sequence, and quality instance
	// variables.
	//
	public boolean equals(Object obj) {
		FastqRecord other = (FastqRecord) obj;

		return this.defline.equals(other.defline) && this.sequence.equals(other.sequence)
				&& this.quality.equals(other.quality);
	}

	//
	// Returns true if the quality contains at least one dollar sign and at least
	// one hash sign.
	//
	public boolean qualityIsLow() {
		return quality.contains("$") && quality.contains("#");
	}

	//
	// Returns the sum of the hash codes of defline, sequence, and quality.
	//
	public int hashCode() {
		return defline.hashCode() + sequence.hashCode() + quality.hashCode();
	}
}
