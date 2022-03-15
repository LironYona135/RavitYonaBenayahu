package com.example.belove.ui.App.IncenseView.IncenseDataUpload;

import static android.app.Activity.RESULT_OK;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.belove.R;
import com.example.belove.databinding.IncenseDataUploadFragmentBinding;
import com.example.belove.models.incense.Incense;
import com.example.belove.ui.App.MainActivity;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.util.UUID;

public class IncenseDataUploadFragment extends Fragment {

    private IncenseDataUploadViewModel incenseDataUploadViewModel;
    private IncenseDataUploadFragmentBinding binding;
    private StorageReference mStorageRef;
    private Uri imgUri;
    private DatabaseReference dbRef;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        incenseDataUploadViewModel = new ViewModelProvider(this).get(IncenseDataUploadViewModel.class);

        dbRef = FirebaseDatabase.getInstance("https://belove-c69da-default-rtdb.europe-west1.firebasedatabase.app")
                .getReference().child("Incense");
        mStorageRef = FirebaseStorage.getInstance().getReference("Images");
        binding = IncenseDataUploadFragmentBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ((AppCompatActivity) getActivity()).getSupportActionBar().hide();
        binding.imageViewIncense.setOnClickListener(v -> {
            fileChooser();
        });


        binding.btnUpload.setOnClickListener(v -> {
            if (imgUri == null) {
                Toast.makeText(getContext(), "נא לבחור תמונה למוצר!", Toast.LENGTH_SHORT).show();
                return;
            }

            fileUploader();
        });

    }

    //upload the file to firebase
    private void fileUploader() {
        //Incense incense =new Incense("headLine test", "description test", 555, "imageID", true);
        Incense incense = new Incense();
        String incenseID = UUID.randomUUID().toString();
        //todo:not sure we need incense id, if the titles get checked
        incense.setIncenseID(incenseID);
        //todo:for that checks the title is unique after retrieving the information
        String incenseTitle = binding.etTitle.getText().toString().trim();
        incense.setTitle(incenseTitle);
        incense.setDescription(binding.etDescription.getText().toString().trim());
        incense.setPrice(Double.parseDouble(binding.etPrice.getText().toString().trim()));
        incense.setInStock(binding.cbInStock.isChecked());
        String imageID = UUID.randomUUID().toString() + "." + incenseDataUploadViewModel.getExtension(imgUri, getActivity());
        incense.setImageID(imageID);
//        String title = binding.etTitle.getText().toString().trim();
//        String description = binding.etDescription.getText().toString().trim();
//        double price = Double.parseDouble(binding.etPrice.getText().toString().trim());
//        String imageID = UUID.randomUUID().toString() + "." + mViewModel.getExtension(imgUri, getActivity());
//        boolean inStock = binding.cbInStock.isChecked();
//        String incenseID = UUID.randomUUID().toString();
        //Incense incense = new Incense(title, description, price, imageID, inStock,incenseID);

dbRef.push().setValue(incense);



      //  FirebaseFirestore.getInstance().collection("Incenses").document(incenseID).set(incense);


        StorageReference Ref = mStorageRef.child(imageID);
        Ref.putFile(imgUri)
                .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(@NonNull UploadTask.TaskSnapshot taskSnapshot) {
                        Toast.makeText(getContext(), "הפריט הועלה בהצלחה!", Toast.LENGTH_SHORT).show();
                        NavHostFragment.findNavController(IncenseDataUploadFragment.this).navigate(R.id.action_incenseDataUploadFragment_to_incenseRecyclerFragment);
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        System.out.println(e);
                    }
                });
    }

    //choose image from phone
    private void fileChooser() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, 1);

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK && data != null && data.getData() != null) {
            imgUri = data.getData();
            binding.imageViewIncense.setImageURI(imgUri);

        }
    }

    @Override
    public void onResume() {
        super.onResume();
        MainActivity.hideBottomNav();
    }

    @Override
    public void onStop() {
        super.onStop();
        MainActivity.showBottomNav();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        binding = null;
    }
}