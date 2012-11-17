package ua.stu.view.scpview;

import ua.stu.view.fragments.AddrPatientFragment;
import ua.stu.view.fragments.BloodPressFragment;
import ua.stu.view.fragments.DiagnoseFragment;
import ua.stu.view.fragments.MedicalHistory;
import ua.stu.view.fragments.PrivatePatientInfoFragment;
import ua.stu.view.scpview.R;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;


@TargetApi(11) 
public class PatientInfo extends Activity implements android.widget.CompoundButton.OnCheckedChangeListener
{
	private static String TAG = "PatientInfo";
	
	private PrivatePatientInfoFragment privatePatientInfo;
	private BloodPressFragment bloodPress;
	private AddrPatientFragment addrPatient;
	private DiagnoseFragment diagnose;
	private MedicalHistory medicalHistory;
	
	private FragmentTransaction fTrans;
	
	private CheckBox chPrivatePatientInfo;
	private CheckBox chBloodPress;
	private CheckBox chAddrPatient;
	private CheckBox chDiagnosPatient;
	private CheckBox chMedicalHistory;
	
	@Override
	public void onCreate(Bundle savedInstanceState)
    {
		setTheme(R.style.Theme_Sherlock);
		
        super.onCreate(savedInstanceState);
        setContentView(R.layout.patientinfo);
        
        init();
    }

	private final void init()
	{
		chPrivatePatientInfo = (CheckBox)findViewById(R.id.check_private_patient_info);
		chBloodPress = (CheckBox)findViewById(R.id.check_blood_press);
		chAddrPatient = (CheckBox)findViewById(R.id.check_addr_patient);
		chDiagnosPatient = (CheckBox)findViewById(R.id.check_diagnos_patient);
		chMedicalHistory = (CheckBox)findViewById(R.id.check_medical_history);
	    
		chPrivatePatientInfo.setOnCheckedChangeListener(this);
		chBloodPress.setOnCheckedChangeListener(this);
		chAddrPatient.setOnCheckedChangeListener(this);
		chDiagnosPatient.setOnCheckedChangeListener(this);
		chMedicalHistory.setOnCheckedChangeListener(this);
		
		privatePatientInfo = new PrivatePatientInfoFragment();
		bloodPress = new BloodPressFragment();
		addrPatient = new AddrPatientFragment();
		diagnose = new DiagnoseFragment();
		medicalHistory = new MedicalHistory();
	}

	@Override
	public void onCheckedChanged(CompoundButton view, boolean checked) 
	{
		fTrans = getFragmentManager().beginTransaction();
		
		switch(view.getId()) {
        case R.id.check_private_patient_info:
            if (checked)
            {
            	fTrans.add(R.id.frame_private_patient_info, privatePatientInfo);
            } else {
            	fTrans.remove(privatePatientInfo);
            }
            break;
		case R.id.check_blood_press:
	        if (checked)
	        {
	        	fTrans.add(R.id.frame_blood_press, bloodPress);
	        } else {
	        	fTrans.remove(bloodPress);
	        }
	        break;
		case R.id.check_addr_patient:
	        if (checked)
	        {
	        	fTrans.add(R.id.frame_addr_patient, addrPatient);
	        } else {
	        	fTrans.remove(addrPatient);
	        }
	        break;
		case R.id.check_diagnos_patient:
	        if (checked)
	        {
	        	fTrans.add(R.id.frame_diagnos_patient, diagnose);
	        } else {
	        	fTrans.remove(diagnose);
	        }
	        break;
		case R.id.check_medical_history:
	        if (checked)
	        {
	        	fTrans.add(R.id.frame_medical_history, medicalHistory);
	        } else {
	        	fTrans.remove(medicalHistory);
	        }
	        break;
		}
		
		fTrans.commit();
	}
}
