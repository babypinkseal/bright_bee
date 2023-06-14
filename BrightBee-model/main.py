import numpy as np
import tensorflow as tf
from flask import Flask, render_template, request

app = Flask(__name__)

# Load the trained model
model = tf.keras.models.load_model('savedmodel.h5')

@app.route('/')
def home():
    return render_template('home.html')

@app.route('/predict/', methods=['POST'])
def predict():
    if request.method == 'POST':
        # Get the values from the query parameters
        Q1 = request.form.get('Q1')
        Q2 = request.form.get('Q2')
        Q3 = request.form.get('Q3')
        Q4 = request.form.get('Q4')
        Q5 = request.form.get('Q5')
        Q6 = request.form.get('Q6')
        Q7 = request.form.get('Q7')
        Q8 = request.form.get('Q8')
        Q9 = request.form.get('Q9')
        Q10 = request.form.get('Q10')
        Q11 = request.form.get('Q11')
        Q12 = request.form.get('Q12')
        Q13 = request.form.get('Q13')
        Q14 = request.form.get('Q14')
        Q15 = request.form.get('Q15')

        try:
            prediction = preprocessDataAndPredict(Q1, Q2, Q3, Q4, Q5, Q6, Q7, Q8, Q9, Q10, Q11, Q12, Q13, Q14, Q15)
            predicted_class = map_predicted_class(prediction)
            return render_template('predict.html', predicted_class=predicted_class)
        except :
            return "Please enter valid values"

def preprocessDataAndPredict(Q1, Q2, Q3, Q4, Q5, Q6, Q7, Q8, Q9, Q10, Q11, Q12, Q13, Q14, Q15):
    test_data = np.array([[Q1, Q2, Q3, Q4, Q5, Q6, Q7, Q8, Q9, Q10, Q11, Q12, Q13, Q14, Q15]]).astype(np.float32)
    prediction = model.predict(test_data)
    return prediction

def map_predicted_class(prediction):
    class_labels = {0: 'kinestetik', 1: 'audio', 2: 'visual'}
    predicted_label = np.argmax(prediction, axis=1)[0]
    return class_labels.get(predicted_label, 'Unknown')

if __name__ == '__main__':
    app.run(debug=True)