package com.example.belove.ui.loginRegister.login;

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
import com.example.belove.databinding.LoginFragmentBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginFragment extends Fragment {

    private LoginFragmentBinding binding;
    private LoginViewModel lViewModel;
    private ProgressDialog progressDialog;
    private FirebaseAuth mAuth;




    @Override
    public View onCreateView(
            LayoutInflater inflater,
            ViewGroup container,
            Bundle savedInstanceState
    ) {

        lViewModel = new ViewModelProvider(this).get(LoginViewModel.class);
        progressDialog = new ProgressDialog(getContext());

        binding = LoginFragmentBinding.inflate(inflater, container, false);
        return binding.getRoot();


    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity();

        binding.createNewAccount.setOnClickListener(v -> {
            NavHostFragment.findNavController(LoginFragment.this).navigate(R.id.action_loginFragment_to_registerFragment);
        });

        mAuth = FirebaseAuth.getInstance();


binding.btnLogin.setOnClickListener(v -> {
    String email = binding.inputEmail.getText().toString();
    String password = binding.inputPassword.getText().toString();


    int validation = lViewModel.performLogin(
            email,
            password
    );
    switch (validation) {
        //error with email
        case 1:
            binding.inputEmail.setError("invalid email");
            break;
        case 2:
            binding.inputPassword.setError("password must have at least 6 characters");
            break;
        case 0:
            progressDialog.setMessage("please wait while logging in");
            progressDialog.setTitle("Logged in");
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.show();
            mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){
                        progressDialog.dismiss();
                        NavHostFragment.findNavController(LoginFragment.this).navigate(R.id.action_loginFragment_to_restOfApp);
                        Toast.makeText(getContext(),"Login successful",Toast.LENGTH_SHORT).show();
                    }else{
                        progressDialog.dismiss();
                        Toast.makeText(getContext(),""+task.getException(),Toast.LENGTH_SHORT).show();
                    }
                }
            });
            break;
    }
});

binding.btnGoogle.setOnClickListener(v -> {
    NavHostFragment.findNavController(LoginFragment.this).navigate(R.id.action_loginFragment_to_googleSignInActivity);
});

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}