/***
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License. You may obtain
 * a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 */
package de.mangelow.network;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.widget.Toast;

public class RadioNetwork extends Activity {

	private Context context;	
	private TelephonyManager tm;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		context = getApplicationContext();

		// Toast current Network Type
		tm = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
		String type = "UNKNOWN";
        switch (tm.getNetworkType()) {
            case TelephonyManager.NETWORK_TYPE_GPRS: type = "GPRS"; break;
            case TelephonyManager.NETWORK_TYPE_EDGE: type = "EDGE"; break;
            case TelephonyManager.NETWORK_TYPE_UMTS: type = "UMTS"; break;
            case TelephonyManager.NETWORK_TYPE_HSDPA: type = "HSDPA"; break;
            case TelephonyManager.NETWORK_TYPE_HSUPA: type = "HSUPA"; break;
            case TelephonyManager.NETWORK_TYPE_HSPA: type = "HSPA"; break;
            case TelephonyManager.NETWORK_TYPE_HSPAP: type = "HSPA+"; break;
            case TelephonyManager.NETWORK_TYPE_LTE: type = "LTE"; break;
            case TelephonyManager.NETWORK_TYPE_IDEN: type = "iDEN"; break;
            case TelephonyManager.NETWORK_TYPE_CDMA: type = "cmdaOne"; break;
            case TelephonyManager.NETWORK_TYPE_1xRTT: type = "CDMA2000 1xRTT"; break;
            case TelephonyManager.NETWORK_TYPE_EVDO_0: type = "CDMA2000 1xEV-DO Rev. 0"; break;
            case TelephonyManager.NETWORK_TYPE_EVDO_A: type = "CDMA2000 1xEV-DO Rev. A"; break;
            case TelephonyManager.NETWORK_TYPE_EVDO_B: type = "CDMA2000 1xEV-DO Rev. B"; break;
            case TelephonyManager.NETWORK_TYPE_EHRPD: type = "CDMA2000 eHRPD"; break;
            /* Constants not defined in SDK yet */
            case 16 /* NETWORK_TYPE_GSM */: type = "GSM"; break;
            /* Temporarily allocated by custom ROMs */
            case 17 /* NETWORK_TYPE_TD_SCDMA */: type = "UMTS (TD-SDCDMA)"; break;
            case 30 /* NETWORK_TYPE_DCHSPAP */: type = "DC-HSPA+"; break;
        }

        /*
 		if (tm.getNetworkType() == TelephonyManager.NETWORK_TYPE_UMTS)type = "UMTS";
		if (tm.getNetworkType() == TelephonyManager.NETWORK_TYPE_EDGE)type = "EDGE";
		if (tm.getNetworkType() == TelephonyManager.NETWORK_TYPE_GPRS)type = "GPRS";
        if (tm.getNetworkType() == TelephonyManager.NETWORK_TYPE_1xRTT)
        */
		Toast.makeText(context, type, Toast.LENGTH_LONG).show();

		// Launch Activity RadioInfo
		Intent i = new Intent();
		i.setClassName( "com.android.settings", "com.android.settings.RadioInfo" );
		startActivity(i);
		
		// Close this Activity
		finish();
	}
}
