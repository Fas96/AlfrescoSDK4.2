package lu01cene;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.*;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.Term;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;

import java.awt.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;

public class IndexFiles {
    public static void main(String[] args) {
        String usage="";
        
        String indexPath="data/lab01";
        String docsPath=null;
        
        boolean create=true;

        for (int i = 0; i < args.length; i++) {
            if("-index".equals(args[i])){
                indexPath=args[i+1];
                i+=1;
            }else if("-docs".equals(args[i])){
                docsPath=args[i+1];
                i+=1;
            }else if("-update".equals(args[i])){
                create=false;
            }
        }
        if(docsPath==null){
            System.err.println("Usage: "+usage);
            System.exit(1);
        }
        final File docDir= new File(docsPath);
        if(!(docDir.exists()||docDir.canRead())){
            System.out.println("Document directory "+ docDir.getAbsolutePath()+" does not exist or is not readable, please check the path");
            System.exit(3);
        }
        LocalDateTime startTime= LocalDateTime.now();
        try {
            System.out.println("Indexing to directoru"+indexPath+"...........");
            Directory dir= FSDirectory.open(new File(indexPath));
            Analyzer analyzer= new StandardAnalyzer( Version.LUCENE_36);
            IndexWriterConfig iwc= new IndexWriterConfig(Version.LUCENE_36,analyzer);

            if(create){
                iwc.setOpenMode(IndexWriterConfig.OpenMode.CREATE);
            }else {
                iwc.setOpenMode(IndexWriterConfig.OpenMode.CREATE_OR_APPEND);
            }
            IndexWriter idxWriter= new IndexWriter(dir,iwc);
            indexDocs(idxWriter,docDir);

            idxWriter.close();
            LocalDateTime endTIme= LocalDateTime.now();
            System.out.println("startTime take for indexing:  "+startTime );
            System.out.println("endTIme take for indexing:  "+endTIme);

        } catch (IOException exception) {
            exception.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static void indexDocs(IndexWriter idxWriter, File file) throws Exception{

        if(file.canRead()){
            if(file.isDirectory()){
                String[] files=file.list();

                if(files!=null){
                    for (int i = 0; i < files.length; i++) {
                        indexDocs(idxWriter,new File(file,files[i]));
                    }
                }else {
                    FileInputStream fis;
                    try {
                        fis=new FileInputStream(file);

                    }catch (FileNotFoundException io){
                        return;
                    }
                    try {
                        var doc= new Document();
                        doc.add(new StringField("path",file.getPath(),Field.Store.YES));
                        doc.add(new LongField("modified", Long.parseLong(file.getPath()),Field.Store.YES));
                        doc.add(new TextField("contents",new BufferedReader(new InputStreamReader(fis, StandardCharsets.UTF_8))));

                        if(idxWriter.getConfig().getOpenMode()== IndexWriterConfig.OpenMode.CREATE){
                            System.out.println("Adding new file: : "+file);
                            idxWriter.addDocument(doc);
                        }else {
                            System.out.println("Updaing new file: : "+file);
                            idxWriter.updateDocument(new Term("path",file.getPath()),doc);
                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                    }finally {
                        fis.close();
                    }

                }
            }
        }
    }
}