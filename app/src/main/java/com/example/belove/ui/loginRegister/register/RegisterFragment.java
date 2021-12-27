package com.example.belove.ui.loginRegister.register;

import androidx.lifecycle.ViewModelProvider;

import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.belove.R;
import com.example.belove.databinding.RegisterFragmentBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterFragment extends Fragment {

    private RegisterFragmentBinding binding;
    private RegisterViewModel rViewModel;
    private ProgressDialog progressDialog;
    private FirebaseAuth mAuth;


    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        rViewModel = new ViewModelProvider(this).get(RegisterViewModel.class);
        progressDialog = new ProgressDialog(getContext());

        binding = RegisterFragmentBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.AlreadyHaveAccount.setOnClickListener(v -> {
            NavHostFragment.findNavController(RegisterFragment.this).navigate(R.id.action_registerFragment_to_loginFragment);
        });

        mAuth = FirebaseAuth.getInstance();


        binding.btnRegister.setOnClickListener(v -> {
            String email = binding.inputEmail.getText().toString();
            String password = binding.inputPassword.getText().toString();

            int validation = rViewModel.performAuth(
                    email,
                    password,
                    binding.inputConfirmPassword.getText().toString()
            );
            switch (validation) {
                //error with email
                case 1:
                    binding.inputEmail.setError("invalid email");
                    break;
                case 2:
                    binding.inputPassword.setError("password must have at least 6 characters");
                    break;
                case 3:
                    binding.inputConfirmPassword.setError("confirm password does not match password");
                    break;
                case 0:
                    progressDialog.setMessage("please wait while registering");
                    progressDialog.setTitle("Registration");
                    progressDialog.setCanceledOnTouchOutside(false);
                    progressDialog.show();
                    mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()){
                                progressDialog.dismiss();
                                Toast.makeText(getContext(),"Registration Successful",Toast.LENGTH_SHORT).show();
                                NavHostFragment.findNavController(RegisterFragment.this).navigate(R.id.action_registerFragment_to_loginFragment);
                            }else {
                                progressDialog.dismiss();
                                Toast.makeText(getContext(), ""+ task.getException(),Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                    break;
            }

        });
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}