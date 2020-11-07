package com.example.gooutside;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

public class SecondFragment extends Fragment {

    List<String> challenges = new ArrayList<String>(Arrays.asList("Pick up a football!", "Go do some push-ups!", "Go run 1km!", "Play some soccer!", "Look at the clouds!", "Take a nice, brisk walk!", "Pick a flower!", "Do 20 jumping jacks!", "Take some deep breaths!", "Toss a frisbee!", "Sweep your sidewalk!", "Go on a hike!", "Climb a tree!", "Do some stretches!", "Take a seat in the grass!", "Do a lap around the block!", "Pick up some leaves!", "Take a nice landscape picture!", "Throw a ball around!", "Walk in a circle!"));

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

        view.findViewById(R.id.button_second).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment);
            }
        });
    }
    public String getRandomChallenge(List<String> challenges){
        Random rand = new Random();
        return challenges.get(rand.nextInt(challenges.size()));
    }
}