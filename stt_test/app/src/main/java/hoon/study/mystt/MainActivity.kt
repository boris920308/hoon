package hoon.study.mystt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.RecognitionListener
import android.speech.RecognizerIntent
import android.speech.SpeechRecognizer
import android.util.Log
import hoon.study.mystt.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var speechRecognizer: SpeechRecognizer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val intent = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH)
        intent.putExtra(RecognizerIntent.EXTRA_CALLING_PACKAGE, packageName)
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, "ko-KR")

        binding.btnStart.setOnClickListener {
            speechRecognizer = SpeechRecognizer.createSpeechRecognizer(this)
            speechRecognizer.setRecognitionListener(object :RecognitionListener {
                override fun onReadyForSpeech(p0: Bundle?) {
                    Log.d("hoon92", "onReadyForSpeech()")
                    binding.tvState.text = "ready"
                }

                override fun onBeginningOfSpeech() {
                    Log.d("hoon92", "onBeginningOfSpeech()")
                    binding.tvState.text = "recoding.."
                }

                override fun onRmsChanged(p0: Float) {
                    Log.d("hoon92", "onRmsChanged(), 입력받는 소리의크기 = $p0")
                }

                override fun onBufferReceived(p0: ByteArray?) {
                    Log.d("hoon92", "onBufferReceived()")
                }

                override fun onEndOfSpeech() {
                    Log.d("hoon92", "onEndOfSpeech()")
                    binding.tvState.text = "end"
                }

                override fun onError(p0: Int) {
                    Log.d("hoon92", "onError()")
                    val message = when (p0) {
                        SpeechRecognizer.ERROR_AUDIO -> "ERR_AUDIO"
                        SpeechRecognizer.ERROR_CLIENT -> "ERR_CLIENT"
                        SpeechRecognizer.ERROR_INSUFFICIENT_PERMISSIONS -> "ERR_NO_PERMISSION"
                        SpeechRecognizer.ERROR_NETWORK -> "ERR_NETWORK"
                        SpeechRecognizer.ERROR_NETWORK_TIMEOUT -> "ERR_NETWORK_TIMEOUT"
                        SpeechRecognizer.ERROR_NO_MATCH -> "ERR_NO_MATCH"
                        SpeechRecognizer.ERROR_RECOGNIZER_BUSY -> "ERR_BUSY"
                        SpeechRecognizer.ERROR_SERVER -> "ERR_SERVER"
                        SpeechRecognizer.ERROR_SPEECH_TIMEOUT -> "ERR_TIMEOUT"
                        else -> "ERR"
                    }
                    binding.tvResult.text = "err"
                    binding.tvState.text = "err: $message"
                }

                override fun onResults(p0: Bundle?) {
                    Log.d("hoon92", "onResults(), ${p0?.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION)}")
                    val resultMsg = p0?.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION) ?: "no result"

                    binding.tvResult.text = "result = $resultMsg"
                    binding.tvState.text = "idle"
                }

                override fun onPartialResults(p0: Bundle?) {
                    Log.d("hoon92", "onPartialResults()")
                }

                override fun onEvent(p0: Int, p1: Bundle?) {
                    Log.d("hoon92", "onEvent()")
                }

            })
            speechRecognizer.startListening(intent)
        }
    }
}