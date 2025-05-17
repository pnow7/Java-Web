package thisisjava.ch20.oracle.sec09;

import lombok.Data;
import java.util.Date;
import java.sql.Blob;

@Data
public class Board {
	private int bno;
	private String btitle;
	private String bcontent;
	private String bwriter;
	private Date bdate;
	private String bfilename;
	private Blob bfiledata;
}
