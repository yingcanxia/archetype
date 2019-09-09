package cn.shadow.archetype.generater;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;

public class GeneratorSqlmap2 {
	public static void main(String[] args) {
		gen();
	}
	public static void gen() {
		List<String>warnings=new ArrayList<String>();
		boolean overwrite=true;
		String genCif[]=new String[1];
		genCif[0]="src/main/resources/config/generatorConfig.xml";
		for(String file:genCif) {
			File configFile=new File(file);
			ConfigurationParser cp=new ConfigurationParser(warnings);
			Configuration config=null;
			try {
				config=cp.parseConfiguration(configFile);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (XMLParserException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			DefaultShellCallback callback=new DefaultShellCallback(overwrite);
			MyBatisGenerator myBatisGenerator=null;
			try {
				myBatisGenerator=new MyBatisGenerator(config, callback, warnings);
			} catch (InvalidConfigurationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				myBatisGenerator.generate(null);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
}
