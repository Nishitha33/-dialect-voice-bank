const recordButton = document.getElementById("recordButton");
const recordStatus = document.getElementById("recordStatus");

const audioUpload = document.getElementById("audioUpload");
const fileName = document.getElementById("fileName");

const transcriptionText =
    document.getElementById("transcriptionText");

let isRecording = false;


/* RECORD BUTTON */

recordButton.addEventListener("click", function () {

    if (!isRecording) {

        isRecording = true;

        recordButton.textContent = "Stop Recording";

        recordStatus.textContent =
            "Recording... Speak clearly.";

        recordButton.style.background = "#8b0000";

    } else {

        isRecording = false;

        recordButton.textContent = "Start Recording";

        recordStatus.textContent =
            "Recording stopped. Ready for transcription.";

        recordButton.style.background = "#222";

    }

});


/* AUDIO FILE UPLOAD */

audioUpload.addEventListener("change", function () {

    if (audioUpload.files.length > 0) {

        const file = audioUpload.files[0];

        fileName.textContent =
            "Selected: " + file.name;

        transcriptionText.innerHTML = `
            <p>
                Audio uploaded successfully.
                Transcription will be generated
                by the Whisper service.
            </p>
        `;

    } else {

        fileName.textContent =
            "No file selected";

    }

});


/* NAVIGATION */

function scrollToRecord() {

    document.getElementById("record")
        .scrollIntoView({
            behavior: "smooth"
        });

}


function scrollToExplore() {

    document.getElementById("explore")
        .scrollIntoView({
            behavior: "smooth"
        });

}


/* DEMO VOICE */

function playDemo(language) {

    alert(
        "Demo audio for " +
        language +
        " will be available after connecting the audio database."
    );

}
