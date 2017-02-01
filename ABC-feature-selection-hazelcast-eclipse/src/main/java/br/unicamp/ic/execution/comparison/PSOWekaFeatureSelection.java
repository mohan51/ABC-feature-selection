package br.unicamp.ic.execution.comparison;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

import br.unicamp.ic.util.FileUtil;

import weka.attributeSelection.ASSearch;
import weka.attributeSelection.AttributeSelection;
import weka.attributeSelection.BestFirst;
import weka.attributeSelection.PSOSearch;
import weka.attributeSelection.GreedyStepwise;
import weka.attributeSelection.LinearForwardSelection;
import weka.attributeSelection.PSOSearch;
import weka.attributeSelection.ScatterSearchV1;
import weka.attributeSelection.WrapperSubsetEval;
import weka.classifiers.Classifier;
import weka.classifiers.Evaluation;
import weka.classifiers.lazy.IBk;
import weka.core.Instances;
import weka.core.SelectedTag;
import weka.core.Utils;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.Normalize;
import weka.filters.unsupervised.attribute.ReplaceMissingValues;
import weka.filters.unsupervised.attribute.Standardize;

public class PSOWekaFeatureSelection {
	
	public static void main(String[] args) throws IOException {
		FileUtil fileUtil = FileUtil.newInstance("comparison_PSO_feature_selection.log"); 
		PSOWekaFeatureSelection wekaFeatureSelection =  new PSOWekaFeatureSelection();
		ReplaceMissingValues replaceMissingValues =  new ReplaceMissingValues();
		// Filtro z-score
		Standardize zscore = new Standardize();
		PSOSearch psoSearch = new PSOSearch();

		fileUtil.writeMsg("AutosFeatureSelectionExecution-----------------------------------------------------------");
		psoSearch.setIndividualWeight(0.1);
		psoSearch.setInertiaWeight(0.1);
		psoSearch.setIterations(20);
		psoSearch.setPopulationSize(20);
		psoSearch.setMutationProb(0.01);
		psoSearch.setReportFrequency(20);
		psoSearch.setSocialWeight(0.8);
		
		fileUtil.writeMsg("PSOSearch----------------------------------------------------------------------------");
		fileUtil.writeMsg(wekaFeatureSelection.execute("autos.arff", psoSearch, replaceMissingValues));

		fileUtil.writeMsg("BCancerFeatureSelectionExecution---------------------------------------------------------");
		
		psoSearch.setIndividualWeight(0.34);
		psoSearch.setInertiaWeight(0.33);
		psoSearch.setIterations(20);
		psoSearch.setPopulationSize(50);
		psoSearch.setMutationProb(0.01);
		psoSearch.setReportFrequency(20);
		psoSearch.setSocialWeight(0.33);
		
		fileUtil.writeMsg("PSOSearch----------------------------------------------------------------------------");
		fileUtil.writeMsg(wekaFeatureSelection.execute("breast-cancer.arff", psoSearch, replaceMissingValues, zscore));
		
		fileUtil.writeMsg("DiabetesFeatureSelectionExecution--------------------------------------------------------");
		
		psoSearch.setIndividualWeight(0.34);
		psoSearch.setInertiaWeight(0.33);
		psoSearch.setIterations(20);
		psoSearch.setPopulationSize(20);
		psoSearch.setMutationProb(0.01);
		psoSearch.setReportFrequency(20);
		psoSearch.setSocialWeight(0.33);
		
		fileUtil.writeMsg("PSOSearch----------------------------------------------------------------------------");
		fileUtil.writeMsg(wekaFeatureSelection.execute("diabetes.arff", psoSearch, replaceMissingValues));

		fileUtil.writeMsg("GlassFeatureSelectionExecution-----------------------------------------------------------");

		psoSearch.setIndividualWeight(0.34);
		psoSearch.setInertiaWeight(0.33);
		psoSearch.setIterations(20);
		psoSearch.setPopulationSize(20);
		psoSearch.setMutationProb(0.01);
		psoSearch.setReportFrequency(20);
		psoSearch.setSocialWeight(0.33);
		
		fileUtil.writeMsg("PSOSearch----------------------------------------------------------------------------");
		fileUtil.writeMsg(wekaFeatureSelection.execute("glass.arff", psoSearch, replaceMissingValues));
		
		fileUtil.writeMsg("HeartCFeatureSelectionExecution----------------------------------------------------------");
		
		psoSearch.setIndividualWeight(0.8); 
		psoSearch.setInertiaWeight(0.1);
		psoSearch.setIterations(20);
		psoSearch.setPopulationSize(20);
		psoSearch.setMutationProb(0.01);
		psoSearch.setReportFrequency(20);
		psoSearch.setSocialWeight(0.1);
		
		fileUtil.writeMsg("PSOSearch----------------------------------------------------------------------------");
		fileUtil.writeMsg(wekaFeatureSelection.execute("heart-c.arff", psoSearch, replaceMissingValues));
		
		fileUtil.writeMsg("HeartStatlogFeatureSelectionExecution----------------------------------------------------------");
		
		psoSearch.setIndividualWeight(0.34);
		psoSearch.setInertiaWeight(0.33);
		psoSearch.setIterations(20);
		psoSearch.setPopulationSize(20);
		psoSearch.setMutationProb(0.01);
		psoSearch.setReportFrequency(20);
		psoSearch.setSocialWeight(0.33);
		
		fileUtil.writeMsg("PSOSearch----------------------------------------------------------------------------");
		fileUtil.writeMsg(wekaFeatureSelection.execute("heart-statlog.arff", psoSearch, replaceMissingValues));
		
		fileUtil.writeMsg("HepaticFeatureSelectionExecution---------------------------------------------------------");
		
		psoSearch.setIndividualWeight(0.45);
		psoSearch.setInertiaWeight(0.1);
		psoSearch.setIterations(20);
		psoSearch.setPopulationSize(20);
		psoSearch.setMutationProb(0.01);
		psoSearch.setReportFrequency(20);
		psoSearch.setSocialWeight(0.45);
		
		fileUtil.writeMsg("PSOSearch----------------------------------------------------------------------------");
		fileUtil.writeMsg(wekaFeatureSelection.execute("hepatitis.arff", psoSearch, replaceMissingValues));
		
		fileUtil.writeMsg("IrisFeatureSelectionExecution------------------------------------------------------------");
		
		psoSearch.setIndividualWeight(0.34);
		psoSearch.setInertiaWeight(0.33);
		psoSearch.setIterations(20);
		psoSearch.setPopulationSize(20);
		psoSearch.setMutationProb(0.01);
		psoSearch.setReportFrequency(20);
		psoSearch.setSocialWeight(0.33);
		
		fileUtil.writeMsg("PSOSearch----------------------------------------------------------------------------");
		fileUtil.writeMsg(wekaFeatureSelection.execute("iris.arff", psoSearch, replaceMissingValues));
		
		fileUtil.writeMsg("LaborFeatureSelectionExecution-----------------------------------------------------------");
		

		psoSearch.setIndividualWeight(0.8);
		psoSearch.setInertiaWeight(0.1);
		psoSearch.setIterations(20);
		psoSearch.setPopulationSize(20);
		psoSearch.setMutationProb(0.01);
		psoSearch.setReportFrequency(20);
		psoSearch.setSocialWeight(0.1);
		
		fileUtil.writeMsg("PSOSearch----------------------------------------------------------------------------");
		fileUtil.writeMsg(wekaFeatureSelection.execute("labor.arff", psoSearch, replaceMissingValues, zscore));
		
		psoSearch.setIndividualWeight(0.34);
		psoSearch.setInertiaWeight(0.33);
		psoSearch.setIterations(80);
		psoSearch.setPopulationSize(20);
		psoSearch.setMutationProb(0.1);
		psoSearch.setReportFrequency(20);
		psoSearch.setSocialWeight(0.33);
		
		fileUtil.writeMsg("PSOSearch----------------------------------------------------------------------------");
		fileUtil.writeMsg(wekaFeatureSelection.execute("labor.arff", psoSearch, replaceMissingValues, zscore));
		
		
		fileUtil.writeMsg("ImageSegmentationFeatureSelectionExecution-----------------------------------------------");
		
		psoSearch.setIndividualWeight(0.34);
		psoSearch.setInertiaWeight(0.33);
		psoSearch.setIterations(80);
		psoSearch.setPopulationSize(20);
		psoSearch.setMutationProb(0.01);
		psoSearch.setReportFrequency(20);
		psoSearch.setSocialWeight(0.33);
		
		fileUtil.writeMsg("PSOSearch----------------------------------------------------------------------------");
		fileUtil.writeMsg(wekaFeatureSelection.execute("segment.arff", psoSearch, replaceMissingValues));
		
		fileUtil.close();
	}
	
	public String execute(String databaseName, ASSearch search, Filter... filter) {
		
		Instances instances;
		
		try {
			instances = new Instances(new FileReader(
					System.getProperty("user.dir") + "/src/main/resources/"
							+ databaseName));
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		if (filter != null) {
			for (int i = 0; i < filter.length; i++) {

				try {
					filter[i].setInputFormat(instances);
				} catch (Exception e) {
					throw new RuntimeException(e);
				}
				try {
					instances = Filter.useFilter(instances,
							filter[i]);
				} catch (Exception e) {
					throw new RuntimeException(e);
				}

			}
		}
		AttributeSelection selection = new AttributeSelection();
		WrapperSubsetEval eval = new WrapperSubsetEval();
		Classifier knn = new IBk();
		eval.setClassifier(knn);
		eval.setFolds(10);

		selection.setEvaluator(eval);
		selection.setSearch(search);
		selection.setFolds(10);
		selection.setSeed(1);
		try {
			selection.SelectAttributes(instances);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		int[] attributes;
		try {
			attributes = selection.selectedAttributes();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		int featureSize = instances.numAttributes() - 1;
 
		int deletedFetures = 0;
		for (int i = 0; i < featureSize; i++) {
			boolean featureIsIncluded = false;
			for (int j = 0; j < attributes.length; j++) {
				if(i == attributes[j]) {
					featureIsIncluded = true;
					break;
				}
			}
			if (!featureIsIncluded) {
				instances.deleteAttributeAt(i - deletedFetures);
				deletedFetures++;
			}
		}
		instances.setClassIndex(instances.numAttributes() - 1);
		Evaluation evalualtion = null;
		try {
			evalualtion = new Evaluation(instances);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		try {
			evalualtion.crossValidateModel(knn, instances, 10, new Random(1));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		// Retorna o valor da classifica��o
		return Utils.arrayToString(attributes)+" "+evalualtion.pctCorrect();
	}
}