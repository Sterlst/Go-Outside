package com.example.gooutside;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.google.android.material.snackbar.Snackbar;

public class SecondFragment extends Fragment {

    List<String> challenges = new ArrayList<String>(Arrays.asList("Pick up a football!", "Go do some push-ups!", "Go run 1km!", "Play some soccer!", "Look at the clouds!", "Take a nice, brisk walk!", "Pick a flower!", "Do 20 jumping jacks!", "Take some deep breaths!", "Toss a frisbee!", "Sweep your sidewalk!", "Go on a hike!", "Climb a tree!", "Do some stretches!", "Take a seat in the grass!", "Do a lap around the block!", "Pick up some leaves!", "Take a nice landscape picture!", "Throw a ball around!", "Walk in a circle!"));

    Challenge user = new Challenge();

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        View view = inflater.inflate(R.layout.fragment_second, container, false);
        TextView challengeText = view.findViewById(R.id.challengeView);
        challengeText.setText(getRandomChallenge(challenges));
        // Inflate the layout for this fragment
        return view;
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.button_yes).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                // Display congratulatory message
                AlertDialog.Builder posMessage = new AlertDialog.Builder(getActivity());
                posMessage.setMessage("I KNOW I'M AWESOME!");
                posMessage.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        user.setCompleted();
                        System.out.println(user.getCompleted());
                        NavHostFragment.findNavController(SecondFragment.this)
                                .navigate(R.id.action_SecondFragment_to_FirstFragment);
                    }
                });
                AlertDialog dialog = posMessage.create();
                dialog.show();
            }
        });

        view.findViewById(R.id.button_no).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Display sad message
                AlertDialog.Builder negMessage = new AlertDialog.Builder(getActivity());
                negMessage.setMessage("ARE YOU SURE YOU WANT TO QUIT!");
                negMessage.setPositiveButton("       YES I'M A QUITTER       ", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        user.setFailed();
                        System.out.println(user.getFailed());
                        NavHostFragment.findNavController(SecondFragment.this)
                                .navigate(R.id.action_SecondFragment_to_FirstFragment);
                    }
                });

                negMessage.setNegativeButton("        NO I CAN DO IT       ", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        return;
                    }
                });
                AlertDialog dialog = negMessage.create();
                dialog.show();
            }
        });
    }

    public String getRandomChallenge(List<String> challenges){
        Random rand = new Random();
        return challenges.get(rand.nextInt(challenges.size()));
    }
}