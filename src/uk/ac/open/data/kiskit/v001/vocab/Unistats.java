package uk.ac.open.data.kiskit.v001.vocab;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLEncoder;
import org.apache.commons.codec.binary.Base64;
import com.hp.hpl.jena.rdf.model.AnonId;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.RDFNode;
import com.hp.hpl.jena.rdf.model.ResIterator;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.rdf.model.ResourceFactory;
import com.hp.hpl.jena.rdf.model.Statement;
import com.hp.hpl.jena.rdf.model.StmtIterator;
import com.hp.hpl.jena.vocabulary.RDF;
import com.hp.hpl.jena.vocabulary.RDFS;

public class Unistats {
	private final static String BASE = "http://data.linkedu.eu/";
	
	public final static String ns_DATA = BASE + "kis/";
	public final static String ns_ONTOLOGY = BASE + "kis/ontology/";
	
	private final static String ns_DSET = ns_DATA + "dataset/";
	private final static String ns_INSTITUTION = ns_DATA + "institution/";
	private final static String ns_COURSE = ns_DATA + "course/";
	private final static String ns_ACCREDITINGBODY = ns_DATA + "accreditingbody/";
	private final static String ns_ACCREDITATION = ns_DATA + "accreditation/";
	private static final String ns_JOBS = ns_DATA + "job/";
	private static final String ns_FEEMARKER = ns_DATA + "feemarker/";
	public final static String ns_SKOLEMIZED = ns_DATA + "genid/";

	// to be used as default in KisCourse
	public final static String ns_COURSE_DEFAULT = ns_COURSE;
	
	// External vocabularies
	public final static String ns_DC = "http://purl.org/dc/terms/";
	public final static String ns_QB = "http://purl.org/linked-data/cube#";
	public final static String ns_RKB_COURSEWARE = "http://courseware.rkbexplorer.com/ontologies/courseware#";
	public static final String ns_AIISO = "http://purl.org/vocab/aiiso/schema#";

	// Known universities
	public final static String ns_SouthHampton = "http://id.southampton.ac.uk/";
	private final static URL vocabularyTTL = Unistats.class.getResource("/uk/ac/open/data/kiskit/v001/vocab/vocabulary.ttl");

	/*
	 * Classes
	 */
	public final static Resource Institution = ResourceFactory.createResource(ns_AIISO + "Institution"); // TODO
																											// replace
	public final static Resource Course = ResourceFactory.createResource(ns_RKB_COURSEWARE + "Course");
	public final static Resource PartTimeCourse = ResourceFactory.createResource(ns_ONTOLOGY + "PartTimeCourse");
	public final static Resource FullTimeCourse = ResourceFactory.createResource(ns_ONTOLOGY + "FullTimeCourse");
	public final static Resource Accreditation = ResourceFactory.createResource(ns_ONTOLOGY + "Accreditation");
	public final static Resource AccreditingBody = ResourceFactory.createResource(ns_ONTOLOGY + "AccreditingBody");
	public final static Resource Observation = ResourceFactory.createResource(ns_QB + "Observation");

	/**
	 * instances
	 * 
	 */

	public final static Resource commonJobs = ResourceFactory.createResource(ns_DSET + "commonJobs");
	public final static Resource continuation = ResourceFactory.createResource(ns_DSET + "continuation");
	public final static Resource courseStages = ResourceFactory.createResource(ns_DSET + "courseStages");
	public static final Resource employment = ResourceFactory.createResource(ns_DSET + "employment");
	public static final Resource degreeClasses = ResourceFactory.createResource(ns_DSET + "degreeClasses");
	public static final Resource entryQualifications = ResourceFactory.createResource(ns_DSET + "entryQualifications");
	public static final Resource jobTypes = ResourceFactory.createResource(ns_DSET + "jobTypes");
	public static final Resource nationalStudentSurveyResults = ResourceFactory.createResource(ns_DSET + "nationalStudentSurveyResults");
	public static final RDFNode nationalStudentSurveyNHSResults = ResourceFactory.createResource(ns_DSET + "nationalStudentSurveyNHSResults");
	public static final Resource salaries = ResourceFactory.createResource(ns_DSET + "salaries");
	public static final RDFNode tariffs = ResourceFactory.createResource(ns_DSET + "tariffs");

	/*
	 * Properties
	 */
	public final static Property courseId = ResourceFactory.createProperty(ns_ONTOLOGY + "courseId");
	public final static Property type = ResourceFactory.createProperty(ns_ONTOLOGY + "type");
	public final static Property title = ResourceFactory.createProperty(ns_DC + "title");
	public final static Property accomodationUrl = ResourceFactory.createProperty(ns_ONTOLOGY + "accomodationUrl");
	public final static Property accomodationUrlW = ResourceFactory.createProperty(ns_ONTOLOGY + "accomodationUrlW");
	public final static Property courseUrl = ResourceFactory.createProperty(ns_ONTOLOGY + "courseUrl");
	public final static Property relatedCourses = ResourceFactory.createProperty(ns_ONTOLOGY + "courseUrl");
	public final static Property ukPrnApply = ResourceFactory.createProperty(ns_ONTOLOGY + "ukPrnApply");
	public final static Property courseUrlW = ResourceFactory.createProperty(ns_ONTOLOGY + "courseUrlW");
	public final static Property supportUrl = ResourceFactory.createProperty(ns_ONTOLOGY + "supportUrl");
	public final static Property supportUrlW = ResourceFactory.createProperty(ns_ONTOLOGY + "supportUrlW");
	public final static Property employUrl = ResourceFactory.createProperty(ns_ONTOLOGY + "employUrl");
	public final static Property employUrlW = ResourceFactory.createProperty(ns_ONTOLOGY + "employUrlW");
	public final static Property learningAndTeachingUrl = ResourceFactory.createProperty(ns_ONTOLOGY + "learningAndTeachingUrl");
	public final static Property learningAndTeachingUrlW = ResourceFactory.createProperty(ns_ONTOLOGY + "learningAndTeachingUrlW");
	public final static Property jacsCode = ResourceFactory.createProperty(ns_ONTOLOGY + "jacsCode");
	public final static Property ldcsCode = ResourceFactory.createProperty(ns_ONTOLOGY + "ldcsCode");
	public final static Property nonCreditAssessment = ResourceFactory.createProperty(ns_ONTOLOGY + "nonCreditAssessment");
	public final static Property assessmentMethodsUrl = ResourceFactory.createProperty(ns_ONTOLOGY + "assessmentMethodsUrl");
	public final static Property assessmentMethodsUrlW = ResourceFactory.createProperty(ns_ONTOLOGY + "assessmentMethodsUrlW");
	public final static Property ucaCourseId = ResourceFactory.createProperty(ns_ONTOLOGY + "ucaCourseId");
	public final static Property feeVariesByYear = ResourceFactory.createProperty(ns_ONTOLOGY + "feeVariesByYear");
	public final static Property feeToBeConfirmed = ResourceFactory.createProperty(ns_ONTOLOGY + "feeToBeConfirmed");
	public final static Property waiverAvailable = ResourceFactory.createProperty(ns_ONTOLOGY + "waiverAvailable");
	public final static Property meansSupport = ResourceFactory.createProperty(ns_ONTOLOGY + "meansSupport");
	public final static Property otherSupport = ResourceFactory.createProperty(ns_ONTOLOGY + "otherSupport");
	public final static Property englishFee = ResourceFactory.createProperty(ns_ONTOLOGY + "englishFee");
	public final static Property northernIrishFee = ResourceFactory.createProperty(ns_ONTOLOGY + "northernIrishFee");
	public final static Property scottishFee = ResourceFactory.createProperty(ns_ONTOLOGY + "scottishFee");
	public final static Property walesFee = ResourceFactory.createProperty(ns_ONTOLOGY + "walesFee");
	public final static Property availableInWelsh = ResourceFactory.createProperty(ns_ONTOLOGY + "availableInWelsh");
	public final static Property mode = ResourceFactory.createProperty(ns_ONTOLOGY + "mode");
	public final static Property awardLevel = ResourceFactory.createProperty(ns_ONTOLOGY + "awardLevel");
	public final static Property averageOfWrittenAssessment = ResourceFactory.createProperty(ns_ONTOLOGY + "averageOfWrittenAssessment");
	public final static Property averageOfCourseworkAssessment = ResourceFactory.createProperty(ns_ONTOLOGY + "averageOfCourseworkAssessment");
	public final static Property averageOfScheduledActivities = ResourceFactory.createProperty(ns_ONTOLOGY + "averageOfScheduledActivities");

	public final static Property accreditation = ResourceFactory.createProperty(ns_ONTOLOGY + "accreditation");
	public final static Property accreditationUrl = ResourceFactory.createProperty(ns_ONTOLOGY + "accreditationUrl");
	public final static Property accreditingBody = ResourceFactory.createProperty(ns_ONTOLOGY + "accreditingBody");
	public final static Property accreditationType = ResourceFactory.createProperty(ns_ONTOLOGY + "accreditationType");
	public final static Property accreditationDependantOnChoice = ResourceFactory.createProperty(ns_ONTOLOGY + "accreditationDependantOnChoice");
	public final static Property accreditationDependantOnChoiceUrl = ResourceFactory.createProperty(ns_ONTOLOGY + "accreditationDependantOnChoiceUrl");
	public final static Property accreditationDependantOnChoiceUrlW = ResourceFactory.createProperty(ns_ONTOLOGY + "accreditationDependantOnChoiceUrlW");
	public final static Property subject = ResourceFactory.createProperty(ns_DC + "subject");
	public final static Property course = ResourceFactory.createProperty(ns_ONTOLOGY + "course");
	public final static Property teaches = ResourceFactory.createProperty(ns_AIISO + "teaches");
	public final static Property taughtAt = ResourceFactory.createProperty(ns_RKB_COURSEWARE + "taught-at");
	public final static Property job = ResourceFactory.createProperty(ns_ONTOLOGY + "job");
	public final static Property percentage = ResourceFactory.createProperty(ns_ONTOLOGY + "percentage");
	public final static Property order = ResourceFactory.createProperty(ns_ONTOLOGY + "order");
	public final static Property population = ResourceFactory.createProperty(ns_ONTOLOGY + "population");
	public final static Property aggregation = ResourceFactory.createProperty(ns_ONTOLOGY + "aggregation");
	public final static Property dataSet = ResourceFactory.createProperty(ns_QB + "dataSet");
	public final static Property continuing = ResourceFactory.createProperty(ns_ONTOLOGY + "continuing");
	public final static Property dormant = ResourceFactory.createProperty(ns_ONTOLOGY + "dormant");
	public final static Property left = ResourceFactory.createProperty(ns_ONTOLOGY + "left");
	public final static Property gained = ResourceFactory.createProperty(ns_ONTOLOGY + "gained");
	public final static Property lower = ResourceFactory.createProperty(ns_ONTOLOGY + "lower");
	public final static Property stage = ResourceFactory.createProperty(ns_ONTOLOGY + "stage");
	public static final Property assessmentMethod = ResourceFactory.createProperty(ns_ONTOLOGY + "assessmentMethod");
	public static final Property coursework = ResourceFactory.createProperty(ns_ONTOLOGY + "coursework");
	public static final Property written = ResourceFactory.createProperty(ns_ONTOLOGY + "written");
	public static final Property practical = ResourceFactory.createProperty(ns_ONTOLOGY + "practical");
	public static final Property learningAndTeachingMethod = ResourceFactory.createProperty(ns_ONTOLOGY + "learningAndTeachingMethod");
	public static final Property independent = ResourceFactory.createProperty(ns_ONTOLOGY + "independent");
	public static final Property placement = ResourceFactory.createProperty(ns_ONTOLOGY + "placement");
	public static final Property scheduled = ResourceFactory.createProperty(ns_ONTOLOGY + "scheduled");
	public static final Property workOrStudy = ResourceFactory.createProperty(ns_ONTOLOGY + "workOrStudy");
	public static final Property assumedUnemployed = ResourceFactory.createProperty(ns_ONTOLOGY + "assumedUnemployed");
	public static final Property workAndStudy = ResourceFactory.createProperty(ns_ONTOLOGY + "workAndStudy");
	public static final Property notAvailable = ResourceFactory.createProperty(ns_ONTOLOGY + "notAvailable");
	public static final Property study = ResourceFactory.createProperty(ns_ONTOLOGY + "study");
	public static final Property work = ResourceFactory.createProperty(ns_ONTOLOGY + "work");
	public static final Property firstClass = ResourceFactory.createProperty(ns_ONTOLOGY + "firstClass");
	public static final Property upperSecondClass = ResourceFactory.createProperty(ns_ONTOLOGY + "upperSecondClass");
	public static final Property lowerSecondClass = ResourceFactory.createProperty(ns_ONTOLOGY + "lowerSecondClass");
	public static final Property otherHonours = ResourceFactory.createProperty(ns_ONTOLOGY + "otherHonours");
	public static final Property ordinary = ResourceFactory.createProperty(ns_ONTOLOGY + "ordinary");
	public static final Property notClassified = ResourceFactory.createProperty(ns_ONTOLOGY + "notClassified");
	public static final Property accessCourse = ResourceFactory.createProperty(ns_ONTOLOGY + "accessCourse");
	public static final Property aLevel = ResourceFactory.createProperty(ns_ONTOLOGY + "aLevel");
	public static final Property baccalaureate = ResourceFactory.createProperty(ns_ONTOLOGY + "baccalaureate");
	public static final Property degree = ResourceFactory.createProperty(ns_ONTOLOGY + "degree");
	public static final Property diploma = ResourceFactory.createProperty(ns_ONTOLOGY + "diploma");
	public static final Property foundation = ResourceFactory.createProperty(ns_ONTOLOGY + "foundation");
	public static final Property noQualifications = ResourceFactory.createProperty(ns_ONTOLOGY + "noQualifications");
	public static final Property other = ResourceFactory.createProperty(ns_ONTOLOGY + "other");
	public static final Property otherHE = ResourceFactory.createProperty(ns_ONTOLOGY + "otherHE");
	public static final Property professional = ResourceFactory.createProperty(ns_ONTOLOGY + "professional");
	public static final Property nonProfessional = ResourceFactory.createProperty(ns_ONTOLOGY + "nonProfessional");
	public static final Property unknown = ResourceFactory.createProperty(ns_ONTOLOGY + "unknown");

	/*
	 * NSS questions
	 */
	public static final Property nssQuestion1 = ResourceFactory.createProperty(ns_ONTOLOGY, "nssQuestion1");
	public static final Property nssQuestion2 = ResourceFactory.createProperty(ns_ONTOLOGY, "nssQuestion2");
	public static final Property nssQuestion3 = ResourceFactory.createProperty(ns_ONTOLOGY, "nssQuestion3");
	public static final Property nssQuestion4 = ResourceFactory.createProperty(ns_ONTOLOGY, "nssQuestion4");
	public static final Property nssQuestion5 = ResourceFactory.createProperty(ns_ONTOLOGY, "nssQuestion5");
	public static final Property nssQuestion6 = ResourceFactory.createProperty(ns_ONTOLOGY, "nssQuestion6");
	public static final Property nssQuestion7 = ResourceFactory.createProperty(ns_ONTOLOGY, "nssQuestion7");
	public static final Property nssQuestion8 = ResourceFactory.createProperty(ns_ONTOLOGY, "nssQuestion8");
	public static final Property nssQuestion9 = ResourceFactory.createProperty(ns_ONTOLOGY, "nssQuestion9");
	public static final Property nssQuestion10 = ResourceFactory.createProperty(ns_ONTOLOGY, "nssQuestion10");
	public static final Property nssQuestion11 = ResourceFactory.createProperty(ns_ONTOLOGY, "nssQuestion11");
	public static final Property nssQuestion12 = ResourceFactory.createProperty(ns_ONTOLOGY, "nssQuestion12");
	public static final Property nssQuestion13 = ResourceFactory.createProperty(ns_ONTOLOGY, "nssQuestion13");
	public static final Property nssQuestion14 = ResourceFactory.createProperty(ns_ONTOLOGY, "nssQuestion14");
	public static final Property nssQuestion15 = ResourceFactory.createProperty(ns_ONTOLOGY, "nssQuestion15");
	public static final Property nssQuestion16 = ResourceFactory.createProperty(ns_ONTOLOGY, "nssQuestion16");
	public static final Property nssQuestion17 = ResourceFactory.createProperty(ns_ONTOLOGY, "nssQuestion17");
	public static final Property nssQuestion18 = ResourceFactory.createProperty(ns_ONTOLOGY, "nssQuestion18");
	public static final Property nssQuestion19 = ResourceFactory.createProperty(ns_ONTOLOGY, "nssQuestion19");
	public static final Property nssQuestion20 = ResourceFactory.createProperty(ns_ONTOLOGY, "nssQuestion20");
	public static final Property nssQuestion21 = ResourceFactory.createProperty(ns_ONTOLOGY, "nssQuestion21");
	public static final Property nssQuestion22 = ResourceFactory.createProperty(ns_ONTOLOGY, "nssQuestion22");
	public static final Property sectorLowerForty = ResourceFactory.createProperty(ns_ONTOLOGY, "sectorLowerForty");
	public static final Property sectorMedianForty = ResourceFactory.createProperty(ns_ONTOLOGY, "sectorMedianForty");
	public static final Property sectorUpperForty = ResourceFactory.createProperty(ns_ONTOLOGY, "sectorUpperForty");
	public static final Property sectorLowerSix = ResourceFactory.createProperty(ns_ONTOLOGY, "sectorLowerSix");
	public static final Property sectorMedianSix = ResourceFactory.createProperty(ns_ONTOLOGY, "sectorMedianSix");
	public static final Property sectorUpperSix = ResourceFactory.createProperty(ns_ONTOLOGY, "sectorUpperSix");
	public static final Property courseLower = ResourceFactory.createProperty(ns_ONTOLOGY, "courseLower");
	public static final Property courseMedian = ResourceFactory.createProperty(ns_ONTOLOGY, "courseMedian");
	public static final Property courseUpper = ResourceFactory.createProperty(ns_ONTOLOGY, "courseUpper");
	public static final Property nhsnssQuestion1 = ResourceFactory.createProperty(ns_ONTOLOGY, "nhsnssQuestion1");
	public static final Property nhsnssQuestion2 = ResourceFactory.createProperty(ns_ONTOLOGY, "nhsnssQuestion2");
	public static final Property nhsnssQuestion3 = ResourceFactory.createProperty(ns_ONTOLOGY, "nhsnssQuestion3");
	public static final Property nhsnssQuestion4 = ResourceFactory.createProperty(ns_ONTOLOGY, "nhsnssQuestion4");
	public static final Property nhsnssQuestion5 = ResourceFactory.createProperty(ns_ONTOLOGY, "nhsnssQuestion5");
	public static final Property nhsnssQuestion6 = ResourceFactory.createProperty(ns_ONTOLOGY, "nhsnssQuestion6");
	public static final Property tariff1 = ResourceFactory.createProperty(ns_ONTOLOGY, "tariff1");
	public static final Property tariff120 = ResourceFactory.createProperty(ns_ONTOLOGY, "tariff120");
	public static final Property tariff160 = ResourceFactory.createProperty(ns_ONTOLOGY, "tariff160");
	public static final Property tariff200 = ResourceFactory.createProperty(ns_ONTOLOGY, "tariff200");
	public static final Property tariff240 = ResourceFactory.createProperty(ns_ONTOLOGY, "tariff240");
	public static final Property tariff280 = ResourceFactory.createProperty(ns_ONTOLOGY, "tariff280");
	public static final Property tariff320 = ResourceFactory.createProperty(ns_ONTOLOGY, "tariff320");
	public static final Property tariff360 = ResourceFactory.createProperty(ns_ONTOLOGY, "tariff360");
	public static final Property tariff400 = ResourceFactory.createProperty(ns_ONTOLOGY, "tariff400");
	public static final Property tariff440 = ResourceFactory.createProperty(ns_ONTOLOGY, "tariff440");
	public static final Property tariff480 = ResourceFactory.createProperty(ns_ONTOLOGY, "tariff480");
	public static final Property tariff520 = ResourceFactory.createProperty(ns_ONTOLOGY, "tariff520");
	public static final Property tariff560 = ResourceFactory.createProperty(ns_ONTOLOGY, "tariff560");
	public static final Property tariff600 = ResourceFactory.createProperty(ns_ONTOLOGY, "tariff600");
	public static final Property numberOfBeds = ResourceFactory.createProperty(ns_ONTOLOGY, "numberOfBeds");
	public static final Property bedsLowerPrice = ResourceFactory.createProperty(ns_ONTOLOGY, "bedsLowerPrice");
	public static final Property bedsUpperPrice = ResourceFactory.createProperty(ns_ONTOLOGY, "bedsUpperPrice");
	public static final Property privateBedsLowerPrice = ResourceFactory.createProperty(ns_ONTOLOGY, "privateBedsLowerPrice");
	public static final Property privateBedsUpperPrice = ResourceFactory.createProperty(ns_ONTOLOGY, "privateBedsUpperPrice");
	public static final Property country = ResourceFactory.createProperty(ns_ONTOLOGY, "country");
	public static final Property nspParticipant = ResourceFactory.createProperty(ns_ONTOLOGY, "nspParticipant");
	public static final Property studentsUnionSatisfactory = ResourceFactory.createProperty(ns_ONTOLOGY, "studentsUnionSatisfactory");
	public static final Property nssPopulation = ResourceFactory.createProperty(ns_ONTOLOGY, "nssPopulation");

	public static void main(String args[]) throws URISyntaxException {

		Model m = getVocabulary();
		PrintStream p = System.out;
		p.println(" -- Unistat Vocabulary -- ");
		p.println();

		// Classes
		p.println(" -- CLASSES -- ");
		p.println();
		ResIterator classes = m.listResourcesWithProperty(RDF.type, RDFS.Class);
		while (classes.hasNext()) {
			Resource c = classes.next();
			p.println("Class: " + c);
			StmtIterator aboutc = c.listProperties();
			while (aboutc.hasNext()) {
				Statement s = aboutc.next();
				p.println(" > " + s.getPredicate());
				p.println("      " + s.getObject());
			}
			p.println();
		}

		p.println(" -- PROPERTIES -- ");
		p.println();
		ResIterator properties = m.listResourcesWithProperty(RDF.type, RDF.Property);
		while (properties.hasNext()) {
			Resource c = properties.next();
			p.println("Property: " + c);
			StmtIterator aboutp = c.listProperties();
			while (aboutp.hasNext()) {
				Statement s = aboutp.next();
				p.println(" > " + s.getPredicate());
				p.println("      " + s.getObject());
			}
			p.println();
		}
	}

	public static Model getVocabulary() {
		Model m = ModelFactory.createDefaultModel();
		try {
			m.read(vocabularyTTL.toURI().toString(), "TTL");
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return m;
	}

	public static final String getInstitutionURI(String ukprn) {
		return ns_INSTITUTION + urify(ukprn);
	}

	public static final String getCourseURI(String ukprn, String kiscourseId) {
		return getCourseURI(ukprn, kiscourseId, ns_COURSE_DEFAULT);
	}

	/**
	 * Builds a course URI with a specified base name
	 * @param ukprn
	 * @param kiscourseId
	 * @param base
	 * @return
	 */
	public static final String getCourseURI(String ukprn, String kiscourseId, String base) {
		if(base == null){
			base = ns_COURSE_DEFAULT;
		}
		return base + urify(ukprn) + "/" + urify(kiscourseId.toLowerCase());
	}
	
	private static String urify(String str){
		// white spaces with +
		try {
			return URLEncoder.encode(str, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return str;
	}

	public static String getJACSURI(String string) {
		// we don't urify this string
		return ns_SouthHampton + "JACS/" + string;
	}
	
	public static String getFeeMarkerURI(String fm){
		return ns_FEEMARKER + urify(fm.toLowerCase());
	}

	public static String getAccreditationURI(String ukprn, String kisCourseId, int x) {
		return ns_ACCREDITATION + urify(ukprn) + "/" + urify(kisCourseId.toLowerCase()) + "/" + Integer.toString(x);
	}

	public static String getAccreditingBodyURI(String code) {
		return ns_ACCREDITINGBODY + urify(code.toLowerCase());
	}

	public static String getJobURI(String codeFromDescription) {
		return ns_JOBS + urify(codeFromDescription.toLowerCase());
	}

	public static String skolemizedURI(AnonId bnodeId){
		return ns_SKOLEMIZED + new String(Base64.encodeBase64(bnodeId.getLabelString().getBytes()));
	}
	
	public static String createSkolemizedResource(){
		return skolemizedURI(ResourceFactory.createResource().getId());
	}
}
