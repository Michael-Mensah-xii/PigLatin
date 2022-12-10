package com.example.piglatin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import java.util.*

class MainActivity : AppCompatActivity() {
    // Add a TextView member variable
    private lateinit var pigLatinTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        pigLatinTextView = findViewById(R.id.pig_latin_text_view)

        // Define the toPigLatin() function outside of onCreate()
        fun toPigLatin(word: String): String {

            // Use the toLowerCase() method instead of lowercase()
            val lowercaseWord = word.lowercase(Locale.getDefault())

            // Check if the word begins with a vowel
            if (lowercaseWord[0] in "aeiou") {
                // If the word begins with a vowel, just add "yay" to the end
                return "${word}yay"
            } else {
                // If the word begins with a consonant, move the first letter to the end and add "ay"
                val firstLetter = lowercaseWord[0]
                val pigLatinWord = "${lowercaseWord.substring(1)}${firstLetter}ay"

                // If the original word was capitalized, capitalize the first letter of the Pig Latin word
                if (word[0].isUpperCase()) {
                    // Use the capitalize() method to capitalize the first letter of the Pig Latin word
                    return pigLatinWord.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }
                }

                // If the original word had any punctuation, add it to the end of the Pig Latin word
                val lastChar = word[word.length - 1]
                if (lastChar in ".,?!") {
                    return "${pigLatinWord}$lastChar"
                }

                return pigLatinWord
            }
        }

        var word = "apple!"
        // Use the pigLatinTextView to display the output of toPigLatin()
        pigLatinTextView.text = toPigLatin(word)
    }
}
