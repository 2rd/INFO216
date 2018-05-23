import org.apache.jena.query.Dataset;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.tdb.TDBFactory;
import org.apache.jena.util.FileManager;

/**
 * A class for creating a TDB from RDF-files.
 */
public class Main {

	//The paths of the RDF-files to be added to the TDB
	private static final String TDB_DIR = "./tdb_reduced";
	private static final String DEM_RDF_PATH = "data/StateDemography.rdf";
	private static final String DEM2_RDF_PATH = "data/StateDemography2.rdf";
	private static final String HOM_RDF_PATH = "data/homicides-reduced.rdf";
	private static final String ISO_RDF_PATH = "data/ISO3166-2.rdf";
	private static final String SCHOOL_RDF_PATH= "data/schoolSpending.rdf";
	
	public static void main(String[] args) {		
		toTDB();		
	}

	/**
	 * Adds the RDF files to the TDB.
	 */
	public static void toTDB() {
		Dataset dataset = TDBFactory.createDataset(TDB_DIR);
		Model model = dataset.getDefaultModel();
		model = FileManager.get().readModel(model, DEM_RDF_PATH);
		model = FileManager.get().readModel(model, DEM2_RDF_PATH);
		model = FileManager.get().readModel(model, HOM_RDF_PATH);
		model = FileManager.get().readModel(model, ISO_RDF_PATH);
		model = FileManager.get().readModel(model, SCHOOL_RDF_PATH);
		dataset.close();
		
	}

}

