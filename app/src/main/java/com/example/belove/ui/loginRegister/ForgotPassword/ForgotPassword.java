package com.example.belove.ui.loginRegister.ForgotPassword;

import androidx.lifecycle.ViewModelProvider;

import android.app.ProgressDialog;
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
import com.example.belove.databinding.ForgotPasswordFragmentBinding;
import com.example.belove.databinding.LoginFragmentBinding;
import com.example.belove.ui.loginRegister.login.LoginFragment;
import com.example.belove.ui.loginRegister.login.LoginViewModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class ForgotPassword extends Fragment {

    private ForgotPasswordViewModel forgotPasswordViewModel;
    private ForgotPasswordFragmentBinding binding;

    public static ForgotPassword newInstance() {
        return new ForgotPassword();
    }

    @Override
    public View onCreateView(
            LayoutInflater inflater,
            ViewGroup container,
            Bundle savedInstanceState
    ) {

        forgotPasswordViewModel = new ViewModelProvider(this).get(ForgotPasswordViewModel.class);

        binding = ForgotPasswordFragmentBinding.inflate(inflater, container, false);
        return binding.getRoot();


    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity();
        binding.btnSendPasswordReset.setOnClickListener(v -> {
            FirebaseAuth.getInstance().sendPasswordResetEmail(binding.inputEmail.getText().toString())
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(getContext(), "email sent", Toast.LENGTH_SHORT).show();
                                NavHostFragment.findNavController(ForgotPassword.this).navigate(R.id.action_forgotPassword_to_loginFragment);
                            }else {
                                Toast.makeText(getContext(), "check if email is written correct", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        });

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}