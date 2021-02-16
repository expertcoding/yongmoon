import connectors.Cassandra;
import connectors.LevelDB;
import connectors.MySQL;
import interfaces.SubDB;
import util.Item;
import util.Options;
import util.Status;
import util.MetaFile;
import db.MalleDB;
public class test{
    public static void main(String[] args){

        System.out.println("Block deleted...011");
        MalleDB malleDB = new MalleDB();
        MetaFile meta = new MetaFile();
        System.out.println("Block deleted...01111");
        Options options = new Options(Options.DB_TYPE.MYSQL, Options.DB_TYPE.CASSANDRA, Options.DB_TYPE.LEVELDB);
        System.out.println("Block deleted...01123");
        malleDB.init(options);
        malleDB.create();

        System.out.println("Block deleted...000");
        String key = "aasdd";
        String key = "asdasdgg";
        meta.setKey(key);
        System.out.println("insert\n");
        malleDB.insertMetaFile(meta);
        System.out.println("update\n");
        malleDB.updateMetaFile(key, meta);
        System.out.println("read\n");
        malleDB.readMetaFile(key);
        System.out.println("delete\n");
        malleDB.deleteMetaFile(key);
        System.out.println("Block deleted...3");
        malleDB.close();

    }

}
