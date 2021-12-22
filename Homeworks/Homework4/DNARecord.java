package dna;

//
// FastqRecord and FastaRecord should implement this.
//
// Remember that in implementing classes, the methods
// listed in the interface have to be public.

// Contains methods that will be implemented in classes that implement DNARecord.

public interface DNARecord {

	// Returns the defline.
	String getDefline();

	// Returns the sequence.
	String getSequence();
}
