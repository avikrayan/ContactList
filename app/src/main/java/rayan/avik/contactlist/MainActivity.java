package rayan.avik.contactlist;

import android.content.ContentResolver;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView contactList;
    ArrayList<ContactPojo> arrayList_contact=new ArrayList<ContactPojo>();
    ContactPojo contactVO;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contactList = (ListView) findViewById(R.id.contactlist);
       getAllContacts();
        contactList.setAdapter(new MyAdapterContact());
    }

    private void getAllContacts() {
        ContentResolver contentResolver = getContentResolver();
        Cursor cursor = contentResolver.query(ContactsContract.Contacts.CONTENT_URI, null, null, null, ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME + " ASC");

    }


    private class MyAdapterContact extends BaseAdapter {
        @Override
        public int getCount() {
            return arrayList_contact.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater=getLayoutInflater();
            View row=inflater.inflate(R.layout.single_contact_view,parent,false);

            ImageView ivContactImage = (ImageView) row.findViewById(R.id.ivContactImage);
            TextView tvContactName = (TextView) row.findViewById(R.id.tvContactName);
            TextView tvPhoneNumber = (TextView) row.findViewById(R.id.tvPhoneNumber);
            return row;
        }
    }
}