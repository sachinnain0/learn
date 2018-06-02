package JSON_Validation.JSON_Validation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.everit.json.schema.Schema;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import org.json.JSONTokener;

/**
 * Hello world!
 *
 */
public class App 
{
	public static void main( String[] args )
	{
		try {
			InputStreamReader inputStream = new InputStreamReader(new FileInputStream("/home/sachin/eclipse-workspace/JSON-Validation/schema.json"));
			InputStreamReader fileStream = new InputStreamReader(new FileInputStream("/home/sachin/eclipse-workspace/JSON-Validation/file.json"));
			JSONObject rawSchema = new JSONObject(new JSONTokener(inputStream));
			Schema schema = SchemaLoader.load(rawSchema);
			
			JSONObject rawfile = new JSONObject(new JSONTokener(fileStream));
			
			schema.validate(rawfile); // throws a ValidationException if this object is invalid
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}
}
